package com.sdk.oms.shopee.service.domain;

import com.sdk.oms.shopee.api.domain.ImageService;
import com.sdk.oms.shopee.core.service.BaseRestClientService;
import com.sdk.oms.shopee.model.image.request.ImageUpload;
import com.sdk.oms.shopee.model.image.response.ImageUploadResult;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.sdk.oms.shopee.constants.PathConstants.IMAGE_UPLOAD_RELATIVE_PATH;
import static com.sdk.oms.shopee.model.image.response.ImageUploadResult.ImageUploadResults;

@Service
public class ImageServiceImpl extends BaseRestClientService implements ImageService {

    private static final int IMAGE_MAX_SIZE = 9;

    @Override
    public List<ImageUploadResult> uploadImages(ImageUpload imageUploadRequest) {
        checkNotNull(imageUploadRequest);
        checkArgument(imageUploadRequest.getImages() != null && imageUploadRequest.getImages().size() <= IMAGE_MAX_SIZE);
        return post(ImageUploadResults.class, uri(IMAGE_UPLOAD_RELATIVE_PATH)).entity(imageUploadRequest).executeWithErrorResponse().getList();
    }
}
