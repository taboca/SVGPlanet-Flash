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

package com.amazonaws.mechanicalturk.rtk.process.review.resolution;


import com.amazonaws.mechanicalturk.rtk.domain.ReviewableHIT;
import com.amazonaws.mechanicalturk.rtk.service.RequesterService;


public abstract class BaseHITHandler
        implements HITHandler {

    //-------------------------------------------------------------
    // Variables
    //-------------------------------------------------------------

    protected RequesterService requesterService;
    private AssignmentHandler assignmentHandler; 


    //-------------------------------------------------------------
    // Constructors
    //-------------------------------------------------------------

    /**
     *
     */
    public BaseHITHandler() {
    }


    //-------------------------------------------------------------
    // Methods - Protected - Abstract
    //-------------------------------------------------------------
    
    protected abstract void handleHIT(ReviewableHIT reviewableHIT)
            throws HITHandlerException;

    
    //-------------------------------------------------------------
    // Implementation - HITHandler
    //-------------------------------------------------------------

    public void resolve(ReviewableHIT reviewableHIT)
            throws HITHandlerException {
        if (assignmentHandler != null) {
            assignmentHandler.resolve(reviewableHIT);
        }
        
        handleHIT(reviewableHIT);
    }

    
    //-------------------------------------------------------------
    // Methods - Public - Configuration
    //-------------------------------------------------------------

    public void setRequesterService(RequesterService requesterService) {
        this.requesterService = requesterService;
    }


    public void setAssignmentHandler(AssignmentHandler assignmentHandler) {
        this.assignmentHandler = assignmentHandler;
    }
}
