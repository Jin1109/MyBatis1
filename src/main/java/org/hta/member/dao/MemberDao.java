/*
  	** mybatis 프레임워크의 핵심 컴포넌트
  	   1) SqlSession : 실제 SQL을 실행하는 객체로 이 객체는 SQL을 처리하기 위해
  	   				   JDBC드라이버를 사용합니다.
  	   
  	   2) SqlSessionFactory : SqlSession 객체를 생성합니다.
  	   
  	   3) SqlSessionFactoryBuilder : 마이바티스 설정 파일의 내용을 토대로 SqlSessionFactory를 생성합니다.
  	   
  	   4) mybatis 설정 파일 : 데이터 베이스 연결 정보, 트랜잭션 정보,
  	   						mybatis 제어 정보 등의 설정 내용을 포함하고 있습니다.
  	   						SqlSessionFactory 를 만들 때 사용됩니다.
  	   
  	   5) SQL 맵퍼 파일 : SQL문을 담고 있는 파일로 SqlSession 객체가 참조합니다.
  	   
  	** SqLSession의 주요 메서드
  	   1) selectList() : select 문을 실행합니다.
  	                     값 객체(Value Object) 목록을 반환합니다.
  	                     쿼리 결과를 List<E>로 반환합니다.
  	                     결과가 없으면 size() 가 0인 List를 반환합니다.
 	   2) selectOne() : select 문을 실행합니다.
 	   					하나의 값 객체(Value Object)를 반환합니다.
 	   					쿼리결과가 없으면 null을 반환합니다.
 	   3) insert() : insert문을 실행합니다. 반환값은 입력한 로우 갯수입니다.
 	   4) update() : update문을 실행합니다. 반환값은 변경한 로우 갯수입니다.
 	   5) delete() : delete문을 실행합니다. 반환값는 삭제한 로우 갯수입니다.
 */
package org.hta.member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hta.member.domain.Member;

public class MemberDao {
	
	private SqlSession getSession() {
		SqlSession session = null;
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("org/hta/mybatis/config/sqlMapConfig.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			session = sf.openSession(true);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

	public int chk(Member member) {
		int result = 0; // 아이디가 없는 경우
		SqlSession session = null;
		try {
			session = getSession();

			// 조회결과가 없는 경우 dbmember는 null 입니다.
			Member dbmember = (Member) session.selectOne("org.hta.mybatis.member.select", member.getId());
			if (dbmember != null) {
				if (dbmember.getId().equals(member.getId())) {
					result = -1; // 아이디는 같고 비번이 다른 경우
					if (dbmember.getPassword().equals(member.getPassword())) {
						result = 1; // 아이디와 비번이 같은 경우
					}
				}
			} else {
				System.out.println("chk() 결과 = null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close(); // SqlSession 을 닫아 자원을 해제합니다.
		}
		return result;
	}

	public int insert(Member member) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.insert("org.hta.mybatis.member.insert", member);
			// result = session.insert("insert", member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close(); //SqlSession 을 닫아 지원을 해제합니다.
		}
		return result;
	}

	public Member select(String id) {
	      Member dbmember = null;
	      SqlSession session = null;
	      try {
	         session = getSession();
	         dbmember = session.selectOne("select", id);
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	      } finally {
	         if(session != null)
	            session.close(); //SqlSession 을 닫아 지원을 해제합니다.
	      }
	      return dbmember;
	   }
	
	public List<Member> list() {
		List<Member> list = null;
		SqlSession session = null;
		try {
			session = getSession();
			list = session.selectList("list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close(); // SqlSession 을 담아 자원을 해제합니다.
		}
		return list;
	}

	public int update(Member mem) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.update("update", mem);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close(); // SqlSession 을 닫아 자원을 해제합니다.
		}
		return result;
	}

	public int delete(String id) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.delete("delete", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close(); // SqlSession 을 닫아 자원을 해제합니다.
		}		
		return result;
	}

	public List<Map<String, String>> list2() {
	      List<Map<String, String>> list = null;
	      SqlSession session = null;
	      try {
	         session = getSession();
	         list = session.selectList("list2");
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	      } finally {
	         if(session != null)
	            session.close(); //SqlSession 을 닫아 지원을 해제합니다.
	      }
	      return list;
	   }



}
