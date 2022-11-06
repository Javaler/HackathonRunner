package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.example.demo.entity.Post;
import com.example.demo.entity.Post_;
import com.example.demo.form.PostQuery;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class PostDaoImpl implements PostDao {
    private final EntityManager entityManager;

    // Criteria APIによる検索
    @Override
    public List<Post> findByCriteria(PostQuery postQuery) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        List<Predicate> predicates = new ArrayList<>();

        // ハッカソン経験
        if (postQuery.getHackathon() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.HACKATHON), postQuery.getHackathon())));
        }

        // チーム開発
        if (postQuery.getTeam() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.TEAM), postQuery.getTeam())));
        }

        // ツール開発
        if (postQuery.getPortfolio() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.PORTFOLIO), postQuery.getPortfolio())));
        }

        // git経験
        if (postQuery.getGit() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.GIT), postQuery.getGit())));
        }

        // 動画編集経験
        if (postQuery.getMovie() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.MOVIE), postQuery.getMovie())));
        }

        // プレゼン経験
        if (postQuery.getPresentation() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.PRESENTATION), postQuery.getPresentation())));
        }

        // デザイン
        if (postQuery.getDesign() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.DESIGN), postQuery.getDesign())));
        }

        // フロントエンド
        if (postQuery.getFrontend() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.FRONTEND), postQuery.getFrontend())));
        }

        // バックエンド開発
        if (postQuery.getBackend() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.BACKEND), postQuery.getBackend())));
        }

        // インフラ
        if (postQuery.getInfrastructure() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.INFRASTRUCTURE), postQuery.getInfrastructure())));
        }

        // データ解析
        if (postQuery.getMachinelearning() != -1) {
            predicates.add(
                builder.and(
                    builder.equal(root.get(Post_.MACHINELEARNING), postQuery.getMachinelearning())));
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
