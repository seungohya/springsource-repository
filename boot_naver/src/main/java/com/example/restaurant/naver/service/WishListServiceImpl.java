package com.example.restaurant.naver.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageItem;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalItem;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import com.example.restaurant.whishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.dto.WishListDTO;
import com.example.restaurant.wishlist.repository.WishListRepository;

@Service
public class WishListServiceImpl implements WishListService {

	@Autowired
	private NaverClient naverClient;
	@Autowired
	private WishListRepository wishListRepository;

	@Override
	public WishListDTO search(String query) {

		// 지역 검색 요청
		SearchLocalReq req = new SearchLocalReq();
		req.setQuery(query);

		// 지역 검색 결과 받기
		SearchLocalRes res = naverClient.searchLocal(req);

		if (res.getTotal() > 0) {

			// 지역 검색 중에서 첫번째 가져오기
			SearchLocalItem localItem = res.getItems().get(0);

			// 해당 가게 사진 검색하기 위해 제목 추출
			String imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");

			// 이미지 검색 요청
			SearchImageReq imageReq = new SearchImageReq();
			imageReq.setQuery(imageQuery);

			// 이미지 검색 결과 받기
			SearchImageRes imageRes = naverClient.searchImage(imageReq);

			if (imageRes.getTotal() > 0) {

				// 이미지 정보들 중에서 첫번째 가져오기
				SearchImageItem imageItem = imageRes.getItems().get(0);

				// 받은 정보들을 원하는 데이터만 추출해서 WishListDTO 담기
				WishListDTO dto = new WishListDTO();
				dto.setTitle(imageQuery);
				dto.setCategory(localItem.getCategory());
				dto.setAddress(localItem.getAddress());
				dto.setRoadAddress(localItem.getRoadAddress());
				dto.setHomePageLink(localItem.getLink());
				dto.setImageLink(imageItem.getLink());
				dto.setVisit(false);
				dto.setVisitCount(0);
				dto.setLastVisitDate(null);

				return dto;

			}
		}
		return new WishListDTO();
	}

	// 데이터 추가
	public WishListDTO add(WishListDTO wishListDTO) {
		WishListEntity entity = dtoToEntity(wishListDTO);
		WishListEntity saveEntity = wishListRepository.save(entity);
		return entityToDto(saveEntity);
	}

	private WishListEntity dtoToEntity(WishListDTO dto) {
		// dto => entity 객체로
		WishListEntity entity = new WishListEntity();
		entity.setIdx(dto.getIdx());
		entity.setTitle(dto.getTitle());
		entity.setCategory(dto.getCategory());
		entity.setAddress(dto.getAddress());
		entity.setRoadAddress(dto.getRoadAddress());
		entity.setHomePageLink(dto.getHomePageLink());
		entity.setImageLink(dto.getImageLink());
		entity.setVisit(dto.isVisit());
		entity.setVisitCount(dto.getVisitCount());
		entity.setLastVisitDate(dto.getLastVisitDate());

		return entity;

	}

	private WishListDTO entityToDto(WishListEntity entity) {
		// entity => dto 객체로
		WishListDTO dto = new WishListDTO();
		dto.setIdx(entity.getIdx());
		dto.setTitle(entity.getTitle());
		dto.setCategory(entity.getCategory());
		dto.setAddress(entity.getAddress());
		dto.setRoadAddress(entity.getRoadAddress());
		dto.setHomePageLink(entity.getHomePageLink());
		dto.setImageLink(entity.getImageLink());
		dto.setVisit(entity.isVisit());
		dto.setVisitCount(entity.getVisitCount());
		dto.setLastVisitDate(entity.getLastVisitDate());

		return dto;
	}

	@Override
	public List<WishListDTO> all() {
//		List<WishListEntity> list = wishListRepository.findAll();
		return wishListRepository.findAll().stream().map(wish -> entityToDto(wish)).collect(Collectors.toList());
	}

}
