package lab01.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import lab01.dao.MemberDao;
import lab01.model.MemberBean;
import utils.HibernateUtils;

public class MemberHibernateDaoImpl implements MemberDao {

	//DataSource ds = null;
	SessionFactory factory;
	public MemberHibernateDaoImpl() {
		factory = HibernateUtils.getSessionFactory();//準備工廠
	}

	private static final String SELECT_BY_MEMBERID = "SELECT memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01 WHERE memberId = ?";

	public MemberBean findByMemberId(String id) {
		MemberBean result = null;
		String hql = "FROM MemberEntity WHERE memberId = :mid";
		Session session = factory.getCurrentSession();
		List<MemberBean> beans= session.createQuery(hql, MemberBean.class)
										.setParameter("mid", id)
										.getResultList();
		if(beans.size()>0) {
			result = beans.get(0);
		}

		return result;
	}

	//private static final String SELECT_ALL = "SELECT id, memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01";

	public List<MemberBean> findAll() {
		String hql = "FROM MemberEntity";
		Session session = factory.getCurrentSession();
		List<MemberBean> result= session.createQuery(hql, MemberBean.class)
										.getResultList();
		return result;
	}

	//private static final String INSERT = "INSERT INTO memberlab01 (memberId, password, name, phone, birthday, registerdate, picture, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public void save(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);

	}

	//private static final String DELETE_BY_MEMBERID = "DELETE FROM memberlab01 WHERE memberId=?";

	public void deleteByMemberId(String memberId) {
		Session session = factory.getCurrentSession();
		MemberBean bean = findByMemberId(memberId);
		session.delete(memberId);
		
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		MemberBean memberBean = findByMemberId(memberId);
		return (memberBean != null);
	}

	private static final String SELECT_BY_ID = "SELECT id, memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01 WHERE id = ?";

	@Override
	public MemberBean findById(Integer id) {
		Session session = factory.getCurrentSession();
		MemberBean memberBean = session.get(MemberBean.class, id);
		return memberBean;
	}

	
	
	//private static final String DELETE_BY_ID = "DELETE FROM memberlab01 WHERE id=?";

	@Override
	public void deleteById(Integer id) {
		Session session = factory.getCurrentSession();
		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);
		session.delete(memberBean);
		return;
	}

	//private static final String UPDATE = "UPDATE memberlab01 set name = ?,  password = ?,  phone = ?, birthday = ?,  weight = ? WHERE id = ?";

	@Override
	public void update(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(memberBean);
	}

	

}