/*
 * ****************************************************************************
 * File: PlayRockPaperScissorsRequest.java
 * Author: Lim Leong Kee
 * Email: leongkee86@gmail.com
 * Last Modified Date: 25 August 2025
 * 
 * Description:
 * This class represents a request body in an API request for playing a
 * challenge session of the Rock-Paper-Scissors game.
 * ****************************************************************************
 */

package com.demo.rest_api.dto;

import com.demo.rest_api.enums.RockPaperScissors;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PlayRockPaperScissorsRequest
{
    private String opponentUsername;

    @NotNull( message = "Your choice is required" )
    private RockPaperScissors yourChoice = RockPaperScissors.Rock;

    @Min( value = 1, message = "Points to stake must be at least 1" )
    private int pointsToStake = 1;

    public void setOpponentUsername( String opponentUsername )
    {
        this.opponentUsername = opponentUsername;
    }

    public String getOpponentUsername()
    {
        return opponentUsername;
    }

    public void setYourChoice( RockPaperScissors yourChoice )
    {
        this.yourChoice = yourChoice;
    }

    public RockPaperScissors getYourChoice()
    {
        return yourChoice;
    }

    public void setPointsToStake( int pointsToStake )
    {
        this.pointsToStake = pointsToStake;
    }

    public int getPointsToStake()
    {
        return pointsToStake;
    }
}
