package com.we.service;

import com.we.vo.MediaVO;

import java.util.List;

/**
 * Created by ID.LQF on 2017/12/22.
 */
public interface MediaService extends BaseService {

    /**
     * 查所有的媒体报道
     * @return
     */
    List<MediaVO> listMedia();

}
