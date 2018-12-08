package com.example.mymvp;

/**
 * @Auther linghailong
 * created at 2018/12/8
 * @duscribe: 是Model层给presenter层反馈信息的载体，所以需要在callBack中定义数据请求的各种反馈载体状态。
 */
public interface MvpCallback {
    /**
     * 数据请求成功时
     *
     * @param data
     */
    void onSuccess(String data);

    /**
     * 使用网络Api接口请求数据时，虽然已请求成功，但是由于{@code msg}的原因而导致无法正常返回数据
     *
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网、
     * 缺少权限，内存泄露等原因导致无法连接到请求数据源。
     */
    void onError();

    /**
     * 当请求数据结束时，无论请求结果是成功，失败或是抛出异常都会执行此方法给用户做处理，通常做网络
     * 请求时可以在此处隐藏“正在加载”的等待控件
     */
    void onComplete();
}
