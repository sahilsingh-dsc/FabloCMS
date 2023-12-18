package com.myfablo.cms.module_menu_sync.contract_add_sub_category;

import com.myfablo.cms.utils.common_req_res.BasicResponse;

public interface AddSubCategoryInterface {

    void onContractProgress();

    void onContractResponse(BasicResponse basicResponse);

    void onContractNotFound();

    void onContractFailure();
}