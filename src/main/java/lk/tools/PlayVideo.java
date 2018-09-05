package lk.tools;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.opensymphony.xwork2.Action;

import java.util.List;

/**
 * @author lk
 * 2018/9/4 11:20
 * @description:
 */
public class PlayVideo {

    private static final String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    private static final String accessKeyId = "LTAIDYKSIXN9yPSZ";
    private static final String accessKeySecret = "yC9v1x1JpyghnGcc2YhzcmpwS3y45a";
    private static final String bucketName = "cqsweet";

    //初始化
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {
        //点播服务所在的Region，国内请填cn-shanghai，不要填写别的区域
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    public static DefaultAcsClient getDefaultAcsClient() {
        return initVodClient(accessKeyId, accessKeySecret);
    }

    public static String getUrl(String videoId) {
        DefaultAcsClient client = getDefaultAcsClient();
        GetPlayInfoResponse response;
        try {
            //获取播放地址
            GetPlayInfoRequest request = new GetPlayInfoRequest();
            request.setVideoId(videoId);
            response = client.getAcsResponse(request);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            //播放地址
            return playInfoList.get(0).getPlayURL();
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
            return null;
        }
    }
}
