package com.example.mymvp;

/**
 * @Auther linghailong
 * created at 2018/12/8
 * @duscribe: 举一个例子，在上述乞丐版MVP架构中的应用请求网络数据时需要等待后台反馈数据后更新界面，但是在请求过程中
 * 当前Activity突然因为某种原因被销毁，Presenter收到后台反馈并调用View接口处理UI逻辑时由于Activity已经被销毁，
 * 就会引发空指针异常。
 */
public class MvpPresenter {
    private MvpView mMvpView;

    public MvpPresenter() {

    }

    /**
     * 绑定View
     * @param mvpView
     */
    public void attachView(MvpView mvpView){
        this.mMvpView=mvpView;
    }
    public void detachView(){
        this.mMvpView=null;
    }

    /**
     * 判断view是否被绑定
     * @return
     */
    public boolean isAttached(){
        return mMvpView!=null;
    }
    public void getData(String params){
        mMvpView.showLoading();
        MvpModel.getData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                mMvpView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                mMvpView.showFailureMessage(msg);
            }

            @Override
            public void onError() {
                mMvpView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                mMvpView.hideLoading();
            }
        });
    }
}
