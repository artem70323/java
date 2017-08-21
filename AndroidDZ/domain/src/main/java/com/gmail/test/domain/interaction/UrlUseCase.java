package com.gmail.test.domain.interaction;


import com.gmail.test.domain.entity.UrlList;
import com.gmail.test.domain.interaction.base.UseCase;

public class UrlUseCase extends UseCase<UrlList> {

    @Override
    public UrlList buildUseCase() {
        UrlList urlList = new UrlList();
        urlList.setAndroidImageUrls(new String[]{"https://i01.fotocdn.net/s16/123/gallery_xs/259/30343802.jpg",
                "https://i01.fotocdn.net/s16/104/gallery_xs/233/9365607.jpg",
                "https://i09.fotocdn.net/s8/205/gallery_m/159/2254347980.jpg",
                "https://i10.fotocdn.net/s16/86/gallery_xs/493/9694293.jpg",
                "https://i05.fotocdn.net/s16/77/gallery_xs/126/32013644.jpg",
                "https://i01.fotocdn.net/s5/226/gallery_xs/341/2180863201.jpg",
                "https://i02.fotocdn.net/s5/202/gallery_xs/54/2189178313.jpg",
                "https://i03.fotocdn.net/s19/30/gallery_xs/2/1066664221.jpg",
                "https://i03.fotocdn.net/s5/147/gallery_xs/341/2180863122.jpg",
                "https://i02.fotocdn.net/s19/165/gallery_xs/239/1073802916.jpg",
                "http://api.learn2crack.com/android/images/donut.png",
                "http://api.learn2crack.com/android/images/eclair.png",
                "http://api.learn2crack.com/android/images/froyo.png",
                "http://api.learn2crack.com/android/images/ginger.png",
                "http://api.learn2crack.com/android/images/honey.png",
                "http://api.learn2crack.com/android/images/icecream.png",
                "http://api.learn2crack.com/android/images/jellybean.png",
                "http://api.learn2crack.com/android/images/kitkat.png",
                "http://api.learn2crack.com/android/images/lollipop.png",
                "http://api.learn2crack.com/android/images/marshmallow.png"});
        return urlList;
    }

}
