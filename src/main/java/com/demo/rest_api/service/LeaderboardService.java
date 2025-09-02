/*
 * ****************************************************************************
 * File: LeaderboardService.java
 * Author: Lim Leong Kee
 * Email: leongkee86@gmail.com
 * Last Modified Date: 25 August 2025
 * 
 * Description:
 * This service class provides functionality for interacting with the
 * leaderboard data. It calculates a user's rank based on their score, number
 * of attempts, and rounds played. It utilizes MongoTemplate for querying the
 * MongoDB database and determines the rank by comparing the user's performance
 * with other users in the database.
 * ****************************************************************************
 */

package com.demo.rest_api.service;

import com.demo.rest_api.model.User;
import com.demo.rest_api.utils.Constants;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardService
{
    private final MongoTemplate mongoTemplate;

    public LeaderboardService( MongoTemplate mongoTemplate )
    {
        this.mongoTemplate = mongoTemplate;
    }

    public long getUserRank( User user)
    {
        Query query = new Query();

        Criteria betterRank = new Criteria().orOperator(
                Criteria.where( Constants.DATABASE_USER_SCORE_KEY ).gt( user.getScore() ),
                new Criteria().andOperator(
                        Criteria.where( Constants.DATABASE_USER_SCORE_KEY ).is( user.getScore() ),
                        Criteria.where( Constants.DATABASE_USER_ATTEMPTS_KEY ).lt( user.getAttempts() )
                ),
                new Criteria().andOperator(
                        Criteria.where( Constants.DATABASE_USER_SCORE_KEY ).is( user.getScore() ),
                        Criteria.where( Constants.DATABASE_USER_ATTEMPTS_KEY ).is( user.getAttempts() ),
                        Criteria.where( Constants.DATABASE_USER_ROUNDS_KEY ).lt( user.getRounds() )
                )
        );

        query.addCriteria( betterRank );

        return mongoTemplate.count( query, User.class ) + 1;
    }
}
