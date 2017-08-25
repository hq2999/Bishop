<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.awt.AlphaComposite " %>
<%@ page import="java.awt.BasicStroke " %>
<%@ page import="java.awt.Color " %>
<%@ page import="java.awt.Graphics2D " %>
<%@ page import="java.awt.RenderingHints " %>
<%@ page import="java.awt.image.BufferedImage " %>
<%@ page import="java.io.File " %>
<%@ page import="java.io.IOException " %>
<%@ page import="javax.imageio.ImageIO " %>
<%@ page import="java.io.ByteArrayOutputStream" %>                                                             
<%@ page import="java.util.Map" %>                                                             
<%@ page import="java.util.HashMap" %>                                                             
<%@ page import="org.apache.commons.codec.binary.Base64" %>                                                             
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="java.util.Random" %>                                                        


<% 
	
	BufferedImage image = null ;
	BufferedImage b = null ;
	BufferedImage g = null ;
	
	Map result = new HashMap();
	
    Random random = new Random(System.currentTimeMillis());
    int x = random.nextInt(150) + 60;
    
    session.setAttribute("x", x);
    System.out.println(session.getAttribute("x"));
    
    int pic_index = random.nextInt(8) + 1;
    
    int top = random.nextInt(30) + 10;
    
	try {
	//	image =  coverImage("E:\\pic\\ground.png", "E:\\pic\\block.png", 10, 10,  70,  115);
		
		BufferedImage origin =  createBufferedImage("E:\\apache-tomcat-6.0.36\\webapps\\ROOT\\" + pic_index + ".jpg");
        g =  createBufferedImage("E:\\apache-tomcat-6.0.36\\webapps\\ROOT\\" + pic_index + ".jpg");
		b = clip(g,x,top,50,50);
	  //ImageIO.write(b, "jpg", new File("E:\\pic\\b.jpg"));
		image = grayProcess(g,x,top,50,50);
	  //ImageIO.write(image, "jpg", new File("E:\\pic\\g.jpg"));
		
	    ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
		ImageIO.write(b, "jpg", outStream);
		byte[] outByte = outStream.toByteArray();
		String base64_brick = new String(Base64.encodeBase64(outByte));
		result.put("brick", base64_brick);
		
		outStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", outStream);
		outByte = outStream.toByteArray();
		String base64_ground= new String(Base64.encodeBase64(outByte));
		result.put("ground", base64_ground);

        outStream = new ByteArrayOutputStream(); 
		ImageIO.write(origin, "jpg", outStream);
		outByte = outStream.toByteArray();
        String base64_origin= new String(Base64.encodeBase64(outByte));
		result.put("origin", base64_origin);

        result.put("top", top);
		out.print(JSON.toJSONString(result));
		
		System.out.println("ok");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
%>


<%!

   public  BufferedImage createBufferedImage(String imagePath) {
        File file = new File(imagePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
	
	/**
	 * 
	 * 图片覆盖（覆盖图压缩到width*height大小，覆盖到底图上）
	 * @param baseFilePath  底图
	 * @param coverFilePath  覆盖图
	 * @param x 起始x轴
	 * @param y 起始y轴
	 * @param width 覆盖宽度
	 * @param height  覆盖长度度
	 * @return
	 * @throws Exception
	 */

	 public BufferedImage coverImage(String baseFilePath, String coverFilePath, int x, int y, int width, int height) throws Exception {
		File baseFile = new File(baseFilePath);// 底图
		BufferedImage buffImg = ImageIO.read(baseFile);
		File coverFile = new File(coverFilePath); // 覆盖层
		BufferedImage coverImg = ImageIO.read(coverFile);
		buffImg = coverImage(buffImg, coverImg, x, y, width, height);
		return buffImg;
	}

	/**
	 * 
	 * 图片覆盖（覆盖图压缩到width*height大小，覆盖到底图上）
	 * @param baseBufferedImage  底图
	 * @param coverBufferedImage  覆盖图
	 * @param x  起始x轴
	 * @param y 起始y轴
	 * @param width  覆盖宽度
	 * @param height  覆盖长度度
	 * @return
	 * @throws Exception
	 */

	 public BufferedImage coverImage(BufferedImage baseBufferedImage, BufferedImage coverBufferedImage, int x, int y, int width, int height) throws Exception {
		// 创建Graphics2D对象，用在底图对象上绘图
		Graphics2D g2d = baseBufferedImage.createGraphics();
		// 绘制
		g2d.drawImage(coverBufferedImage, x, y, width, height, null);
		g2d.dispose();// 释放图形上下文使用的系统资源
		return baseBufferedImage;
	}
	
	//剪切处理
  BufferedImage clip(BufferedImage baseBufferedImage, int srcX,int srcY,int width,int height){
        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(baseBufferedImage, 0, 0, width, height, srcX, srcY, srcX + width, srcY + height, null);
        g.dispose();
        return newImg;
    }
	
  public BufferedImage grayProcess(BufferedImage source,int x, int y, int width, int height) throws IOException{  
//        //创建BufferedImage对象  
//        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        // 获取Graphics2D   
        Graphics2D g2d = source.createGraphics();  
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.4f));// 1.0f为透明度 ，值从0-1.0，依次变得不透明   
          
        // 画图BasicStroke是JDK中提供的一个基本的画笔类,我们对他设置画笔的粗细，就可以在drawPanel上任意画出自己想要的图形了。  
        g2d.setColor(new Color(255, 255, 255));  
        g2d.setStroke(new BasicStroke(1f));  
        g2d.fillRect(x, y, width, height);  
          
        // 释放对象 透明度设置结束  
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));  
        g2d.dispose();  
          
        return source;
    }  

%>