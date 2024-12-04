package masjidmuar.project.bms.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masjidmuar.project.bms.dto.UserDTO;
import masjidmuar.project.bms.model.User2;
import masjidmuar.project.bms.repository.User2Repository;

@Service
public class UserService {
    @Autowired
    private User2Repository user2Repository;

    public List<UserDTO> getAllUsers() {
        return user2Repository.findAll()
                             .stream()
                             .map(this::mapToDTO)
                             .collect(Collectors.toList());
    }

    public UserDTO getUserById(UUID id) {
        User2 user = user2Repository.findById(id)
                                   .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User2 user = mapToEntity(userDTO);
        user2Repository.save(user);
        return mapToDTO(user);
    }

    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        User2 user = user2Repository.findById(id)
                                   .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user2Repository.save(user);
        return mapToDTO(user);
    }

    public void deleteUser(UUID id) {
        user2Repository.deleteById(id);
    }

    private UserDTO mapToDTO(User2 user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    private User2 mapToEntity(UserDTO dto) {
        User2 user = new User2();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
