package com.qualcomm.vuforia.samples.SampleApplication.utils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Plane to reder 2D image
 */
public class PlaneObject extends  MeshObject{

    private static final double PlaneVertices[] ={

            /*-1.00f, -1.00f, 1.00f, // front face of a cube
            1.00f, -1.00f, 1.00f,
            1.00f, 1.00f, 1.00f,
            -1.00f, 1.00f, 1.00f,*//*
                              -0.5, -0.5, 1,
                                0.0, 0.5, 1,
                              -0.5, 0.0, 1,
                                0.5, 0.5, 1,
                              0.0, -0.5,1,
                                0.5, 0.0, 1,*/
            /*-5, -5, 0,
            0.0, 5, 0,
            -5, 0.0, 0,
            5, 5, 0,
            0.0, -5,0,
            5, 0.0, 0*//*
            -5, -5, 1,
            5, 5, 1,
            -5, 5, 1,
            -5, -5, 1,
            5, 5, 1,
            5, -5, 1*/

            -15, -15, 1,
            15, -15, 1,
            15, 15, 1,
            15, 15, 1,
            -15, 15, 1,
            -15, -15, 1};

    private static final double PlaneTexcoords[] ={0, 0, 2, 0, 2, 2, 0, 2};

    private static final double PlaneNormals[] ={ 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1};

    private static final double PlaneIndices[] ={0, 1, 2, 0, 2, 3};

    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    public PlaneObject()
    {
        mVertBuff = fillBuffer(PlaneVertices);
        mTexCoordBuff = fillBuffer(PlaneTexcoords);
        mNormBuff = fillBuffer(PlaneNormals);
        mIndBuff = fillBuffer(PlaneIndices);
    }

    @Override
    public Buffer getBuffer(MeshObject.BUFFER_TYPE bufferType)
    {
        Buffer result = null;
        switch (bufferType)
        {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_INDICES:
                result = mIndBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
            default:
                break;
        }
        return result;
    }


    @Override
    public int getNumObjectVertex()
    {
        return PlaneVertices.length / 3 ;
    }


    @Override
    public int getNumObjectIndex()
    {
        return PlaneIndices.length;
    }
}
