/*
 * Copyright 2005 Amazon.com, Inc. or its affiliates. All rights reserved.
 *
 * The Requester Toolkit software code ("Software") is made available to you
 * without charge to download, install, display, reproduce, modify and create
 * derivative works of and redistribute, subject to the following conditions:
 * 
 * The Software is provided "AS-IS" and with all faults, errors, bugs and
 * defects.  MECHANICAL TURK AND ITS AFFILIATES HERE BY DISCLAIM ALL WARRANTIES
 * OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION, ANY IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE, OR
 * NON-INFRINGEMENT.  TO THE FULL EXTENT PERMISSIBLE UNDER APPLICABLE LAW,
 * MECHANICAL TURK HEREBY DISCLAIMS, AND YOU WAIVE, ANY AND ALL SUCH WARRANTIES.
 * IN ADDITION, MECHANICAL TURK HEREBY DISCLAIMS ANY OBLIGATION, LIABILITY,
 * RIGHT, CLAIM, OR REMEDY IN TORT, NOTWITHSTANDING ANY FAULT, NEGLIGENCE,
 * STRICT LIABILITY OR PRODUCT LIABILITY OF MECHANICAL TURK OR ITS AFFILIATES
 * (WHETHER ACTIVE, PASSIVE OR IMPUTED).
 * 
 * MECHANICAL TURK AND ITS AFFILIATES WILL NOT BE LIABLE FOR ANY DAMAGES OF ANY
 * KIND, WHETHER DIRECT, INDIRECT, INCIDENTAL, PUNITIVE OR CONSEQUENTIAL,
 * ARISING OUT OF OR RELATED TO YOUR USE OF THE SOFTWARE.
 */

package com.amazonaws.mechanicalturk.rtk.service;

import com.amazonaws.mechanicalturk.rtk.service.security.AWSAccessKey;
import com.amazonaws.mechanicalturk.rtk.service.security.HMACSigner;


/**
 *
 */
public abstract class AWSService {

    //-------------------------------------------------------------
    // Variables - Private
    //-------------------------------------------------------------

    private AWSAccessKey accessKey;
    private HMACSigner signer;


    //-------------------------------------------------------------
    // Constructors
    //-------------------------------------------------------------

    public AWSService() {
        
    }
    
    
    //-------------------------------------------------------------
    // Methods - Configuration
    //-------------------------------------------------------------

    public void setAccessKey(AWSAccessKey accessKey) {
        this.accessKey = accessKey;
        
        signer = new HMACSigner(accessKey.getAccessKey());
    }

    
    //-------------------------------------------------------------
    // Methods - Protected
    //-------------------------------------------------------------

    protected String getAWSAccessKeyId() {
        return accessKey.getAccessKeyId();
    }
    
    
    protected HMACSigner getSigner() {
        return signer;
    }
}
