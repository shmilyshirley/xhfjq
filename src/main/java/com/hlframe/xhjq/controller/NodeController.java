package com.hlframe.xhjq.controller;

import com.hlframe.xhjq.service.NodeService;
import com.hlframe.xhjq.utils.DateUtils;
import com.hlframe.xhjq.utils.EncodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-02-05 14:34
 */
@RestController
@RequestMapping(value = "node")
public class NodeController {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "getNodeInfo")
    public String getNodeInfo(){
        // 打印时间
        getDatetime();
        String encodeNode = EncodeUtils.EncodeByBase64(nodeService.getNodeInfo());
        return encodeNode + "=";
    }

    // 长期用户节点（半年、年费用户）
    @RequestMapping(value = "longTimeUser")// 第999999条记录
    public String getLongTimeNode(){

        return null;
    }

    // 短期用户节点（月费、季度用户）
    @RequestMapping(value = "usualUser")// 第1314条记录
    public String getNode(){

        return null;
    }

    // 全设备 短期用户节点（五月份到期用户）
    @RequestMapping(value = "maayyUser")// 第55555条记录
    public void getMayNode(HttpServletResponse response) throws IOException {
        String fileName = "MayNode.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            // 打印时间
            getDatetime();
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getMayNodeInfo()).getBytes("GBK");
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }
    }

    // 全设备 短期用户节点（四月份到期用户）
    @RequestMapping(value = "aprilllUser")// 第4444条记录
    public void getAprilNode(HttpServletResponse response) throws IOException {
        String fileName = "AprilNode.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            // 打印时间
            getDatetime();
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getAprilNodeInfo()).getBytes("GBK");
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }

    }

    // 2019年七月份 全设备节点获取（Windows，//Android，iOS，Mac）
    @RequestMapping(value = "juuuuullyUser")// 第7777777条记录
    public void getJulyFile(HttpServletResponse response) throws IOException {
        String fileName = "julyNode.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            // 打印时间
            getDatetime();
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getMonthNode(7777777)).getBytes("GBK");
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }
    }

    // 2019 八月份 全设备节点获取（Windows，//Android，iOS，Mac）
    @RequestMapping(value = "augggggUser")// 第88888888条记录
    public void getAugFile(HttpServletResponse response) throws IOException {
        String fileName = "augNode.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            // 打印时间
            getDatetime();
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getMonthNode(88888888)).getBytes("GBK");
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }
    }

    // 2019 九月份-十二月份 全设备节点获取（Windows，//Android，iOS，Mac）
    @RequestMapping(value = "nniineeeeeToDecUser")// 第999999999条记录
    public void getNineToDecFile(HttpServletResponse response) throws IOException {
        String fileName = "nineToDec.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            // 打印时间
            getDatetime();
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getMonthNode(999999999)).getBytes("GBK");
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }
    }

    // 2020年以后 全设备节点获取（Windows，//Android，iOS，Mac）
    @RequestMapping(value = "afterTweentyyyUser")// 第2020条记录
    public void getAfterTwentyFile(HttpServletResponse response) throws IOException {
        String fileName = "afterTwentyNode.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            // 打印时间
            getDatetime();
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getMonthNode(2020)).getBytes("GBK");
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }
    }

    // 2021年以后 全设备节点获取（Windows，//Android，iOS，Mac）
    @RequestMapping(value = "afterrrrTwweenttyOnnneeUser")// 第2021条记录
    public void getAfterTwentyOneFile(HttpServletResponse response) throws IOException {
        String fileName = "afterTwentyOneNode.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            // 打印时间
            getDatetime();
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getMonthNode(2021)).getBytes("GBK");
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }
    }

    // 全设备节点获取（Windows，//Android，iOS，Mac）
    @RequestMapping(value = "allDevicesGetNodeInfo")
    public void getNodeFile(HttpServletResponse response) throws IOException {
        String fileName = "node.txt";
        OutputStream os = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            byte[] bytes = EncodeUtils.EncodeByBase64(nodeService.getNodeInfo()).getBytes("GBK");
            // 打印时间
            getDatetime();
            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }
    }

    // 打印日志时间
    public void getDatetime(){
        System.out.println("——————————————————————————————— LogDateTime ： " + DateUtils.getCurrentDate() + " ———————————————————————————————");
    }
}
