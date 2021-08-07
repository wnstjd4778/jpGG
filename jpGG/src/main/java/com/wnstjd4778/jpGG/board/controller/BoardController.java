package com.wnstjd4778.jpGG.board.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wnstjd4778.jpGG.board.service.BoardService;
import com.wnstjd4778.jpGG.board.vo.ArticleVO;
import com.wnstjd4778.jpGG.member.vo.MemberVO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/listArticles", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List<ArticleVO> articlesList = boardService.listArticles();
		mav.setViewName("listArticles");
		return mav;
	}
	@RequestMapping(value="/articleForm")
	public ModelAndView articleForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("articleForm");
		return mav;
	}

	@RequestMapping(value = "/addNewArticle", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		String imageFileName = upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String id = memberVO.getMemberId();
		System.out.println(memberVO.getMemberPassword());
		articleMap.put("parentNo", 0);
		articleMap.put("id", id);
		articleMap.put("imageFileName", imageFileName);

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int articleNo = boardService.addNewArticle(articleMap);
			if (imageFileName != null && imageFileName.length() != 0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}
			message = "<script>";
			message += " alert('새글을 추가했습니다.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/listArticles'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
			srcFile.delete();

			message = " <script>";
			message += " alert('오류가 발생했습니다');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/articleForm'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}

		return resEnt;
	}
	
	@RequestMapping(value="/viewArticle", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, 
									HttpServletRequest request,
									HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewArticle");
		ArticleVO articleVO = boardService.viewArticle(articleNO);
		mav.addObject("articleVO",articleVO);
		return mav;
	}
	
	@RequestMapping(value="/modArticle", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,
									HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}
		
		String imageFileName = upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		articleMap.put("imageFileName", imageFileName);
		
		String articleNO = (String)articleMap.get("articleNO");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modArticle(articleMap);
			if(imageFileName != null && imageFileName.length() != 0 ) {
				File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				FileUtils.moveToDirectory(srcFile, destDir, true);
				
				String originalFileName = (String)articleMap.get("originalFileName");
				File oldFile = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO+"\\"+originalFileName);
				oldFile.delete();
			}
			message = "<script>";
			message += " alert('수정하였습니다');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/listArticles'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
			srcFile.delete();

			message = " <script>";
			message += " alert('오류가 발생했습니다');";
			message += " location.href='" + multipartRequest.getContextPath() + "/board/articleForm'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}

		return resEnt;
		
	}
	
	@RequestMapping(value="/board/removeArticle", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO, 
										HttpServletRequest request,
										HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.deleteArticle(articleNO);
			File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
			FileUtils.deleteDirectory(destDir);
			
			message = "<script>";
			message += " alert('삭제했습니다');";
			message += " location.href='" + request.getContextPath() + "/board/listArticles';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다');";
			message += " location.href='" + request.getContextPath() + "/board/listArticles';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		
		return resEnt;
	}
	
	
	

	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		String imageFileName = null;
		Iterator<String> fileNames = multipartRequest.getFileNames();

		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFileName = mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + fileName);
			if (mFile.getSize() != 0) {
				if (!file.exists()) {
					if(file.getParentFile().mkdir()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName));
			}
		}
		return imageFileName;
	}

}
