package com.example.mymvp;

/**
 * @Auther linghailong
 * created at 2018/12/8
 * @duscribe: view接口是Activity与Presenter层的中间层，他的作用是根据业务的需要，
 * 为Presenter提供activity中的UI执行逻辑操作的方法
 */
public interface MvpView {
    /**
     * 加载进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载的进度框
     */
    void hideLoading();

    /**
     * 当数据请求成功后调用此接口显示数据
     * @param data
     */
    void showData(String data);

    /**
     * 当数据显示失败后调用此接口显示失败信息
     * @param msg
     */
    void showFailureMessage(String msg);

    /**
     * 数据请求异常显示此接口
     */
    void showErrorMessage();

}
