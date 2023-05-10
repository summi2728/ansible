---
- hosts: debian
  become: yes
  vars: 
     - java_deb: openjdk-11-jdk
     - java_rhel: java-1.8.0-openjdk
  tasks:
    - name: install java in debian
      apt:
        name: "{{ java_deb }}"
        state: latest
        update_cache: yes
      when: ansible_os_family == "debian"
  
    - name: install java in rhel
      yum:
        name: "{{ java_rhel }}"
        state: present
        update_cache: yes
      when: ansible_os_family == "RedHat"      

