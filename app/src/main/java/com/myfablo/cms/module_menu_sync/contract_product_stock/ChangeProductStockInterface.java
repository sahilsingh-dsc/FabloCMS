package com.myfablo.cms.module_menu_sync.contract_product_stock;

import com.myfablo.cms.utils.common_req_res.BasicResponse;

public interface ChangeProductStockInterface {

    void onContractProgress();
    void onContractResponse(BasicResponse basicResponse);
    void onContractNotFound();
    void onContractFailure();

}
