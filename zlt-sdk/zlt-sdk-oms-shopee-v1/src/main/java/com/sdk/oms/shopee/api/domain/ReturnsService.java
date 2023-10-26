package com.sdk.oms.shopee.api.domain;

import com.sdk.oms.shopee.core.common.RestService;
import com.sdk.oms.shopee.model.returns.request.ReturnDisputeRequest;
import com.sdk.oms.shopee.model.returns.request.ReturnsIdRequest;
import com.sdk.oms.shopee.model.returns.request.ReturnsPaginationRequest;
import com.sdk.oms.shopee.model.returns.response.ReturnActionResult;
import com.sdk.oms.shopee.model.returns.response.ReturnDetail;

/**
 * Returns Service
 */
public interface ReturnsService extends RestService {


    /**
     * Confirm Return
     *
     * @param idRequest id
     * @return result
     */
    ReturnActionResult confirmReturn(ReturnsIdRequest idRequest);

    /**
     * Dispute Return
     *
     * @param disputeRequest dispute request
     * @return result
     */
    ReturnActionResult disputeReturn(ReturnDisputeRequest disputeRequest);

    /**
     * Get Return List
     *
     * @param query query
     * @return return details
     */
    ReturnDetail.ReturnDetails getReturnList(ReturnsPaginationRequest query);
}
