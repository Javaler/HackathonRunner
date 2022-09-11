package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.example.demo.entity.Post;
import com.example.demo.entity.Post_;
import com.example.demo.form.HomeQuery;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class HomeDaoImpl implements HomeDao {
  private final EntityManager entityManager;


  // Criteria APIによる検索
  @Override
  public List<Post> findByCriteria(HomeQuery homeQuery) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Post> query = builder.createQuery(Post.class);
    Root<Post> root = query.from(Post.class);
    List<Predicate> predicates = new ArrayList<>();

    // ハッカソン経験
    if (homeQuery.getHackathon() != -1) {
    	predicates.add(builder.and(builder.equal(root.get(Post_.HACKATHON), homeQuery.getHackathon())));
    }
    
    // チーム開発
    if (homeQuery.getTeam() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.TEAM), homeQuery.getTeam())));
    }

    // ツール開発
    if (homeQuery.getPortfolio() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.PORTFOLIO), homeQuery.getPortfolio())));
    }
    
    // git経験
    if (homeQuery.getGit() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.GIT), homeQuery.getGit())));
    }
    
    // 動画編集経験
    if (homeQuery.getMovie() != -1) {
      predicates.add(
        builder.and(
         builder.equal(root.get(Post_.MOVIE), homeQuery.getMovie())));
    }
    
    // プレゼン経験
    if (homeQuery.getPresentation() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.PRESENTATION), homeQuery.getPresentation())));
    }
    
    // デザイン
    if (homeQuery.getDesign() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.DESIGN), homeQuery.getDesign())));
    }
    
    // フロントエンド
    if (homeQuery.getFrontend() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.FRONTEND), homeQuery.getFrontend())));
    }
    
    // バックエンド開発
    if (homeQuery.getBackend() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.BACKEND), homeQuery.getBackend())));
    }
    
    // インフラ
    if (homeQuery.getInfrastructure() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.INFRASTRUCTURE), homeQuery.getInfrastructure())));
    }
    
    // データ解析
    if (homeQuery.getMachineLearning() != -1) {
      predicates.add(
        builder.and(
          builder.equal(root.get(Post_.MACHINELEARNING), homeQuery.getMachineLearning())));
    }

    // SELECT作成
    Predicate[] predArray = new Predicate[predicates.size()];
    predicates.toArray(predArray);
    query = query.select(root).where(predArray).orderBy(builder.desc(root.get(Post_.id)));
   
    // 検索
    List<Post> list = entityManager.createQuery(query).getResultList();

    return list;
  }
}
