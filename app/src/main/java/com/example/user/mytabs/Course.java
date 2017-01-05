package com.example.user.mytabs;

/**
 * Created by user on 2017/1/5.
 */

public class Course
{
    private Teacher mTeacher;
    private String mName;
    private int mLikeCnt;
    private int mNeutralCnt;
    private int mDislikeCnt;

    public Course()
    {
        mLikeCnt = 0;
        mNeutralCnt = 0;
        mDislikeCnt = 0;
    }

    public Course(Teacher teacher, String name, int likeCnt, int neutralCnt, int dislikeCnt)
    {
        mTeacher = teacher;
        mName = name;
        mLikeCnt = likeCnt;
        mNeutralCnt = neutralCnt;
        mDislikeCnt = dislikeCnt;
    }

    public Teacher getTeacher()
    {
        return mTeacher;
    }

    public void setTeacher(Teacher teacher)
    {
        mTeacher = teacher;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public int getLikeCnt()
    {
        return mLikeCnt;
    }

    public void setLikeCnt(int likeCnt)
    {
        mLikeCnt = likeCnt;
    }

    public int getNeutralCnt()
    {
        return mNeutralCnt;
    }

    public void setNeutralCnt(int neutralCnt)
    {
        mNeutralCnt = neutralCnt;
    }

    public int getDislikeCnt()
    {
        return mDislikeCnt;
    }

    public void setDislikeCnt(int dislikeCnt)
    {
        mDislikeCnt = dislikeCnt;
    }
}
