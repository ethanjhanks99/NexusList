package com.nexuslist.backend.nexuslist.Folder;


import java.util.List;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.nexuslist.backend.nexuslist.Security.UserAuthService;
import com.nexuslist.backend.nexuslist.User.User;
import com.nexuslist.backend.nexuslist.exception.ResourceNotFoundException;

@Service
public class FolderService {
    private final FolderRepository folderRepository;
    private final UserAuthService userAuthService;

    public FolderService(FolderRepository folderRepository, UserAuthService userAuthService) {
        this.folderRepository = folderRepository;
        this.userAuthService = userAuthService;
    }

    public Folder getFolder(Long folderId) {
        User currentUser = userAuthService.getCurrentUser();

        Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new ResourceNotFoundException("Folder does not exist with id: " + folderId));

        if (!folder.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You do not have permission to view this folder");
        }

        return folder;
    }

    public List<Folder> getFoldersForCurrentUser() {
        return folderRepository.findByUser(userAuthService.getCurrentUser());
    }
}
