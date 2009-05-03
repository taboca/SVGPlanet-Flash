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


import com.amazonaws.mechanicalturk.rtk.domain.Assignment;
import com.amazonaws.mechanicalturk.rtk.domain.ReviewableHIT;
import com.amazonaws.mechanicalturk.rtk.service.RequesterService;
import com.amazonaws.mechanicalturk.rtk.service.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BasicAssignmentHandler
        implements AssignmentHandler {

    //-------------------------------------------------------------
    // Variables - Private
    //-------------------------------------------------------------

    protected RequesterService requesterService;
    private boolean rejectUnspecifiedDesiredStatus = true;

    private static final Log log = LogFactory.getLog(BasicAssignmentHandler.class);


    //-------------------------------------------------------------
    // Constructors
    //-------------------------------------------------------------

    /**
     *
     */
    public BasicAssignmentHandler() {
    }


    //-------------------------------------------------------------
    // Implementation - AssignmentHandler
    //-------------------------------------------------------------

    public void resolve(ReviewableHIT reviewableHIT)
            throws HITHandlerException {
        for (Assignment assignment : reviewableHIT.getCompletedAssignments()) {
            if (assignment.getStatus() == Assignment.Status.Submitted) {
                try {
                    if (assignment.getDesiredStatus() != null) {
                        switch (assignment.getDesiredStatus()) {
                        case Approved:
                            requesterService.approveAssignment(assignment.getId());
                            break;
    
                        case Rejected:
                            requesterService.rejectAssignment(assignment.getId());
                            break;
                        }
                    } else {
                        if (rejectUnspecifiedDesiredStatus) {
                            requesterService.rejectAssignment(assignment.getId());
                        }
                    }
                } catch (ServiceException e) {
                    throw new HITHandlerException("Unable to approve/reject assignment "
                                                  + assignment.getId(), e);
                }
            } else {
                log.info("Assignment " + assignment.getId() + " in "
                         + assignment.getStatus() + " state.  Bypassing.");
            }
        }
    }


    //-------------------------------------------------------------
    // Methods - Public - Configuration
    //-------------------------------------------------------------

    public void setRequesterService(RequesterService requesterService) {
        this.requesterService = requesterService;
    }


    public void setRejectUnspecifiedDesiredStatus(boolean rejectUnspecifiedDesiredStatus) {
        this.rejectUnspecifiedDesiredStatus = rejectUnspecifiedDesiredStatus;
    }
}
