/*
 * ****************************************************************************
 * File: ChangeDisplayNameRequest.java
 * Author: Lim Leong Kee
 * Email: leongkee86@gmail.com
 * Last Modified Date: 25 August 2025
 * 
 * Description:
 * This class represents the request body in an API request for changing the
 * user's display name.
 * ****************************************************************************
 */

package com.demo.rest_api.dto;

import com.demo.rest_api.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChangeDisplayNameRequest
{
    @NotBlank( message = "Display name is required." )
    @Size( min = Constants.DISPLAY_NAME_LENGTH, message = "Display name must be at least " + Constants.DISPLAY_NAME_LENGTH + " characters long." )
    private String displayName;

    public void setDisplayName( String displayName )
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }
}
