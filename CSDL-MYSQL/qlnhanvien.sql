-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 24, 2022 lúc 11:12 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlnhanvien`
--
CREATE DATABASE IF NOT EXISTS `qlnhanvien` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `qlnhanvien`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dean`
--

CREATE TABLE `dean` (
  `MADA` varchar(30) NOT NULL,
  `TENDA` varchar(50) DEFAULT NULL,
  `DIADIEMDA` varchar(50) DEFAULT NULL,
  `MAPB` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `dean`
--

INSERT INTO `dean` (`MADA`, `TENDA`, `DIADIEMDA`, `MAPB`) VALUES
('mda1', 'Sản phẩm x', 'Hà Nội', 'mpb3'),
('mda2', 'Sản phẩm y', 'Hà Nam', 'mpb1'),
('mda3', 'Sản phẩm z', 'Khánh Hòa', 'mpb2'),
('mda4', 'Sản phảm a', 'Bắc Giang', 'mpb3'),
('mda5', 'Sản phẩm 4', 'Hải phòng', 'mpb2'),
('mda6', 'Sản phẩm 14', 'Hải Dương', 'mpb4'),
('mda7', 'Sản phẩm 15', 'Thanh Hóa', 'mpb1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` varchar(30) NOT NULL,
  `TENNV` varchar(30) NOT NULL,
  `GIOITINH` int(11) NOT NULL,
  `LUONG` float NOT NULL,
  `NGAYSINH` varchar(30) NOT NULL,
  `DIACHI` varchar(50) NOT NULL,
  `MAPB` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `GIOITINH`, `LUONG`, `NGAYSINH`, `DIACHI`, `MAPB`) VALUES
('mnv1', 'Trần Văn Toàn', 0, 5000000, '28/03/2001', 'Thôn 3, Tiến Thắng, Lý Nhân, Hà Nam', 'mpb1'),
('mnv2', 'Trần Tiến Huy', 0, 1000000, '30/04/2001', 'Thôn 3, Tiến Thắng , Lý Nhân, Hà Nam', 'mpb3'),
('mnv3', 'Trần thị a', 1, 242323, '3/4/3435', 'thôn7', 'mpb4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phancong`
--

CREATE TABLE `phancong` (
  `MANV` varchar(30) DEFAULT NULL,
  `MADA` varchar(30) DEFAULT NULL,
  `SOGIO` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phancong`
--

INSERT INTO `phancong` (`MANV`, `MADA`, `SOGIO`) VALUES
('mnv1', 'mda1', 30),
('mnv2', 'mda7', 100);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongban`
--

CREATE TABLE `phongban` (
  `MAPB` varchar(50) NOT NULL,
  `TENPB` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phongban`
--

INSERT INTO `phongban` (`MAPB`, `TENPB`) VALUES
('mpb1', 'Quản lý nhân sự'),
('mpb2', 'Kế Toán'),
('mpb3', 'Trợ Lý 1'),
('mpb4', 'Vệ sinh'),
('mpb5', 'Vệ sinh 1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dean`
--
ALTER TABLE `dean`
  ADD PRIMARY KEY (`MADA`),
  ADD KEY `MAPB` (`MAPB`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`),
  ADD KEY `MAPB` (`MAPB`);

--
-- Chỉ mục cho bảng `phancong`
--
ALTER TABLE `phancong`
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MADA` (`MADA`);

--
-- Chỉ mục cho bảng `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`MAPB`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `dean`
--
ALTER TABLE `dean`
  ADD CONSTRAINT `dean_ibfk_1` FOREIGN KEY (`MAPB`) REFERENCES `phongban` (`MAPB`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`MAPB`) REFERENCES `phongban` (`MAPB`);

--
-- Các ràng buộc cho bảng `phancong`
--
ALTER TABLE `phancong`
  ADD CONSTRAINT `phancong_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `phancong_ibfk_2` FOREIGN KEY (`MADA`) REFERENCES `dean` (`MADA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
