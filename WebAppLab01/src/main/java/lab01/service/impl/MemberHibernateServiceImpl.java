package lab01.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lab01.dao.MemberDao;
import lab01.model.MemberBean;
import lab01.service.MemberService;

@Service("memberHibernateServiceImpl")
@Transactional
public class MemberHibernateServiceImpl implements MemberService {
	
	MemberDao memberDao = null;
	SessionFactory factor = null;
	
public MemberHibernateServiceImpl(MemberDao memberDao, SessionFactory factor) {
		super();
		this.memberDao = memberDao;
		this.factor = factor;
	}

//	public MemberHibernateServiceImpl() {
////		memberDao = new MemberHibernateDaoImpl();
////		factor = HibernateUtils.getSessionFactory();
//	}	

	public MemberBean findById(Integer id) {
		MemberBean merberBean = null;
//		Session session = factor.getCurrentSession();
//		Transaction tx = null;
//		
//		try {
//tx =  session.beginTransaction();
			merberBean = memberDao.findById(id);
			
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(e);
//		}
//		
		return merberBean;
	}
	
	public List<MemberBean> findAll() {
		List<MemberBean> beans = new ArrayList<>();
		
//		Session session = factor.getCurrentSession();
//		Transaction tx = null;
//		
//		try {
//			tx =  session.beginTransaction();
			beans = memberDao.findAll();
			
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(e);
//		}
		
		return beans;
	}

	public void save(MemberBean bean) {
		
//		Session session = factor.getCurrentSession();
//		Transaction tx = null;
//		
//		try {
//			tx =  session.beginTransaction();
			memberDao.save(bean);
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(e);
//		}
//		
		 
	}


	public void deleteById(Integer id) {
		
//		Session session = factor.getCurrentSession();
//		Transaction tx = null;
//		
//		try {
//			tx =  session.beginTransaction();
			memberDao.deleteById(id);
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(e);
//		}
//		
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		
		boolean result = false;
//		Session session = factor.getCurrentSession();
//		Transaction tx = null;
//		
//		try {
//			tx =  session.beginTransaction();
			result= memberDao.existsByMemberId(memberId);
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(e);
//		}
		
		return result;
	}

	@Override
	public void update(MemberBean memberBean) {
//		Session session = factor.getCurrentSession();
//		Transaction tx = null;
//		
//		try {
//			tx =  session.beginTransaction();
			memberDao.update(memberBean);
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(e);
		//}
		
		
		
	}
}