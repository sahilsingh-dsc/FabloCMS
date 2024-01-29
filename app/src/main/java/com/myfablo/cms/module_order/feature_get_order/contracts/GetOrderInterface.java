package com.myfablo.cms.module_order.feature_get_order.contracts;

import com.myfablo.cms.module_order.feature_get_order.models.response.OrderResponse;

public interface GetOrderInterface {

    void onContractProgress();
    void onContractResponse(OrderResponse body);
    void onContractNotFound();
    void onContractFailure();

}
