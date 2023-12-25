package com.ba.boost.service;

import com.ba.boost.dto.request.BaseRequestDto;
import com.ba.boost.exception.ErrorType;
import com.ba.boost.exception.UserProfileMicroserviceException;
import com.ba.boost.repository.IUserProfileRepository;
import com.ba.boost.repository.entity.UserProfile;
import com.ba.boost.utility.JwtTokenManager;
import com.ba.boost.utility.ServiceManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, String> {

    private final IUserProfileRepository repository;

    private final JwtTokenManager jwtTokenManager;

    public UserProfileService(IUserProfileRepository repository, JwtTokenManager jwtTokenManager) {
        super(repository);
        this.repository = repository;
        this.jwtTokenManager = jwtTokenManager;
    }


/*    public List<UserProfile> findAll(Long authId) {
        Optional<UserProfile> userProfile = repository.findOptionalByAuthId(authId);
        if (userProfile.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.UNAUTHORIZED_REQUEST);
        return findAll();
    }*/

//    public List<UserProfile> findAll(BaseRequestDto dto) {
//        Optional<Long> authId = jwtTokenManager.getByIdFromToken(dto.getToken());
//        if (authId.isEmpty())
//            throw new UserProfileMicroserviceException(ErrorType.INVALID_TOKEN);
//        Optional<UserProfile> userProfile = repository.findOptionalByAuthId(authId.get());
//        if (userProfile.isEmpty())
//            throw new UserProfileMicroserviceException(ErrorType.UNAUTHORIZED_REQUEST);
//        return findAll();
//    }

    public Page<UserProfile> findAll(BaseRequestDto dto) {
        Optional<Long> authId = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (authId.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.INVALID_TOKEN);
        Optional<UserProfile> userProfile = repository.findOptionalByAuthId(authId.get());
        if (userProfile.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.UNAUTHORIZED_REQUEST);

        /**
         * Sort.Direction.fromString(dto.getDirection()) -> "ASC" - "DESC" -> Enum
         * dto.getSortParameter() -> ID'ye göre sırala, username göre sırala.
         */
        Sort sort = null;
        Pageable pageable = null;
        /**
         * Sıralama parametresi mutlaka dolu gelmeli, değil ise default bir değer atanmalı.
         * Hangi alanın sıralanacağı isteğe bağlıdır, eğer sıralama alanı belirtilmemiş ise sıralama yapmayın.
         */
        if (dto.getSortParameter() != null) {
            sort = Sort.by(Sort.Direction.fromString(dto.getDirection() == null ? "ASC" : dto.getDirection()),
                    dto.getSortParameter());
        }
        /**
         * dto.getCurrentPage() -> hangi sayfadasın
         * dto.getPageSize() -> bir sayfada gösterilecek kayıt sayısı nekadar
         * sort -> sıralama var mı
         */
        if (sort != null && dto.getCurrentPage() != null) {
            pageable = PageRequest.of(dto.getCurrentPage(), dto.getPageSize() == 0 ? 2 : dto.getPageSize(), sort);
        } else if (sort == null && dto.getCurrentPage() != null) {
            pageable = PageRequest.of(dto.getCurrentPage(), dto.getPageSize() == 0 ? 2 : dto.getPageSize());
        } else {
            pageable = PageRequest.of(0, dto.getPageSize() == 0 ? 2 : dto.getPageSize());
        }
        return findAll(pageable);
    }

    /**
     * Redis kullanarak çıktısı aynı olan bir methodu cachlemiş olduk.
     * Aynı değerle attıgımız request 3 sn'nin biraz üzerinde dönerken,
     * yine aynı değerle ikinci atacağımız request cachlenmiş olduğundan 10 ms'de döner yani saniyenin 10/1000,
     * bu sebeble redis kullanmak requestleri hızlandırır ancak redis kullanmanın sorunu ram maliyetlerini arttırmasıdır,
     * bu artıştan ötürü sunucu maliyetlerimiz artar.
     *
     * @param name
     * @return
     */
    @Cacheable(value = "getuppercase")
    public String getUpperCase(String name) {
        try {
            Thread.sleep(3000L);
        } catch (Exception e) {

        }
        return name.toUpperCase();
    }

    /**
     * getuppercase datasının altında cachelenmiş tüm datayı siler..
     * cacheNames = cachein silinecegi address.
     * allEntries = tüm data
     */
    @CacheEvict(cacheNames = "getuppercase", allEntries = true)
    public void clearCache() {
        System.out.println("Cache have been cleaned.....");
    }

}
