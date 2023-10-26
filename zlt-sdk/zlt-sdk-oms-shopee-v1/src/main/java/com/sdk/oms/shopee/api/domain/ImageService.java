package com.sdk.oms.shopee.api.domain;

import com.sdk.oms.shopee.core.common.RestService;
import com.sdk.oms.shopee.model.image.request.ImageUpload;
import com.sdk.oms.shopee.model.image.response.ImageUploadResult;

import java.util.List;

/**
 * Shopee Image Service
 */
public interface ImageService extends RestService {

    /**
     * Uploads Images
     *
     * @param imageUploadRequest images to uplods
     * @return uploaded images result
     */
    List<ImageUploadResult> uploadImages(ImageUpload imageUploadRequest);

}
