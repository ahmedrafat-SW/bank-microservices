package org.rafat.dev.accounts.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.rafat.dev.accounts.dao.BaseDao;
import org.rafat.dev.accounts.dao.CustomerDao;
import org.rafat.dev.accounts.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {


    @Override
    public Customer getById(Long id) {
        return findById(id);
    }

    @Override
    public void delete(Long id) {
       deleteById(id);
    }

    @Override
    public Customer getCustomerByMobileNumber(String mobileNumber){
        Session session = getSession();
        Query<Customer> query = session.
                createQuery("select c from Customer c where c.mobileNumber = :mobile",
                        Customer.class);

        query.setParameter("mobile", mobileNumber);
        List<Customer> resultList = query.getResultList();

        return (resultList != null && !resultList.isEmpty()) ? resultList.get(0) : null;
    }



}
