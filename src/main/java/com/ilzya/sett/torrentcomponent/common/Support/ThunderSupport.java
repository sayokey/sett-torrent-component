package com.ilzya.sett.torrentcomponent.common.Support;

import com.ilzya.sett.torrentcomponent.common.Thunder;
import com.ilzya.sett.torrentcomponent.exception.ServiceException;
import com.ilzya.sett.torrentcomponent.utils.StringUtil;

import java.io.IOException;

/**
 * 迅雷实现
 *
 * @author sayokey
 * @date 2023/03/28
 */
public class ThunderSupport implements Thunder {

    @Override
    public void addMagnetTask(String magent) {
        magent = StringUtil.decodeIfEncoded(magent);
        String command = "cmd /c start thunder://"+magent;
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(String.format("调用迅雷下载失败:%s",e.getMessage()),-1);
        }
    }
}
