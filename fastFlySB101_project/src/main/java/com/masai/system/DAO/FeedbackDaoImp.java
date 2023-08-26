package com.masai.system.DAO;

import com.masai.system.DTO.Feedback;
import com.masai.system.Util.DbUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FeedbackDaoImp implements FeedbackDao {

    @Override
    public void addFeedback(Feedback feedback) {
        try (EntityManager entityManager = DbUtil.getEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(feedback);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Feedback getFeedbackById(int feedbackId) {
        try (EntityManager entityManager = DbUtil.getEntityManager()) {
            return entityManager.find(Feedback.class, feedbackId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        try (EntityManager entityManager = DbUtil.getEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(feedback);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFeedbackById(int feedbackId) {
        try (EntityManager entityManager = DbUtil.getEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Feedback feedback = entityManager.find(Feedback.class, feedbackId);
            if (feedback != null) {
                entityManager.remove(feedback);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}