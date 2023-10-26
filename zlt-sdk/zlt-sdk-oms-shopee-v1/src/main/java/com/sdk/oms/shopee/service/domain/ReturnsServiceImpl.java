package com.sdk.oms.shopee.service.domain;


import com.sdk.oms.shopee.api.domain.ReturnsService;
import com.sdk.oms.shopee.core.service.BaseRestClientService;
import com.sdk.oms.shopee.model.returns.request.ReturnDisputeRequest;
import com.sdk.oms.shopee.model.returns.request.ReturnsIdRequest;
import com.sdk.oms.shopee.model.returns.request.ReturnsPaginationRequest;
import com.sdk.oms.shopee.model.returns.response.ReturnActionResult;
import com.sdk.oms.shopee.model.returns.response.ReturnDetail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.sdk.oms.shopee.constants.PathConstants.*;
@Service
public class ReturnsServiceImpl extends BaseRestClientService implements ReturnsService {

    @Override
    public ReturnActionResult confirmReturn(ReturnsIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getReturnsn());
        return post(ReturnActionResult.class, uri(RETURNS_CONFIRM_RELATIVE_PATH)).entity(idRequest).executeWithErrorResponse();
    }

    @Override
    public ReturnActionResult disputeReturn(ReturnDisputeRequest disputeRequest) {
        checkNotNull(disputeRequest);
        checkArgument(!StringUtils.isEmpty(disputeRequest.getReturnsn()) && disputeRequest.getDisputeReason() != null);
        return post(ReturnActionResult.class, uri(RETURNS_DISPUTE_RELATIVE_PATH)).entity(disputeRequest).executeWithErrorResponse();
    }

    @Override
    public ReturnDetail.ReturnDetails getReturnList(ReturnsPaginationRequest query) {
        checkNotNull(query);
        return post(ReturnDetail.ReturnDetails.class, uri(RETURNS_GET_LIST_RELATIVE_PATH)).entity(query).executeWithErrorResponse();

    }
}
