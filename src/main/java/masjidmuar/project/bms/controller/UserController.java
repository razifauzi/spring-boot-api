package masjidmuar.project.bms.controller;

import masjidmuar.project.bms.model.User;
import masjidmuar.project.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {
// Add a base URL for consistency

        @Autowired
        private UserRepository userRepository;

        // Get all income
        @GetMapping
        public List<User> getAllUser() {
            return userRepository.findAll();
        }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new user
    @PostMapping("add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


        // Update an existing income
        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
            return userRepository.findById(id).map(user -> {
                user.setName(updatedUser.getName());
                user.setRole(updatedUser.getRole());
                user.setDescription(updatedUser.getDescription());
                User savedUser = userRepository.save(user);
                return ResponseEntity.ok(savedUser);
            }).orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Delete income
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
            try {
                userRepository.deleteById(id);
                return ResponseEntity.ok("Data deleted successfully!");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
            }
        }
    }


