-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 16, 2019 lúc 11:28 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `csdl_lon`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_lon_nai`
--

CREATE TABLE `chi_tiet_lon_nai` (
  `MS_Chi_Tiet_Lon_Nai` int(11) NOT NULL,
  `Ngay_Nhap_Lon_Nai` date DEFAULT NULL,
  `Ngay_Phoi` date DEFAULT NULL,
  `Ngay_De` date DEFAULT NULL,
  `Chu_Ky` int(11) DEFAULT NULL,
  `So_Lan_Phoi` int(11) DEFAULT NULL,
  `So_Lan_De` int(11) DEFAULT NULL,
  `So_Con_Con` int(11) DEFAULT NULL,
  `So_Con_Chet` int(11) DEFAULT NULL,
  `So_Con_Chet_Kho` int(11) DEFAULT NULL,
  `So_Con_Di_Tat` int(11) DEFAULT NULL,
  `So_Con_Chet_Theo_Me` int(11) DEFAULT NULL,
  `Ngay_Xuat_Lon_Nai` date DEFAULT NULL,
  `Gia_Ban_Lon_Nai` int(11) DEFAULT NULL,
  `MS_Tai_Lon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_lon_nai`
--

INSERT INTO `chi_tiet_lon_nai` (`MS_Chi_Tiet_Lon_Nai`, `Ngay_Nhap_Lon_Nai`, `Ngay_Phoi`, `Ngay_De`, `Chu_Ky`, `So_Lan_Phoi`, `So_Lan_De`, `So_Con_Con`, `So_Con_Chet`, `So_Con_Chet_Kho`, `So_Con_Di_Tat`, `So_Con_Chet_Theo_Me`, `Ngay_Xuat_Lon_Nai`, `Gia_Ban_Lon_Nai`, `MS_Tai_Lon`) VALUES
(2, '2019-10-01', '2019-12-06', '2020-03-30', 1, 1, 0, 12, 2, 4, 2, 0, '2021-03-18', 30000, 3),
(3, '2019-07-08', '2019-12-01', '2020-03-25', 1, 2, 1, 16, 3, 2, 1, 0, '2021-12-16', 30000, 4),
(42, '2019-07-01', '2019-12-12', '2020-04-05', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_lon_thit`
--

CREATE TABLE `chi_tiet_lon_thit` (
  `MS_Chi_Tiet_Lon_Thit` int(11) NOT NULL,
  `Ngay_Nhap_Lon_Thit` date DEFAULT NULL,
  `Ngay_Xuat_Lon_Thit` date DEFAULT NULL,
  `Gia_Ban_Lon_Thit` int(11) DEFAULT NULL,
  `MS_Tai_Lon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_thuc_an`
--

CREATE TABLE `chi_tiet_thuc_an` (
  `MS_Chi_Tiet_Thuc_An` int(11) NOT NULL,
  `Don_Gia_Thuc_An` int(11) DEFAULT NULL,
  `So_Luong_Thuc_An` int(11) DEFAULT NULL,
  `Ngay_Nhap_Thuc_An` date DEFAULT NULL,
  `Han_Su_Dung_Thuc_An` date DEFAULT NULL,
  `MS_Thuc_An` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_tiem`
--

CREATE TABLE `chi_tiet_tiem` (
  `MS_Chi_Tiet_Tiem` int(11) NOT NULL,
  `Ngay_Tiem` date DEFAULT NULL,
  `Khoang_Ngay` int(11) DEFAULT NULL,
  `MS_Vac_Xin` int(11) NOT NULL,
  `MS_Tai_Lon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_tieu_thu_thuc_an`
--

CREATE TABLE `chi_tiet_tieu_thu_thuc_an` (
  `MS_Chi_Tiet_Tieu_Thu_Thuc_An` int(11) NOT NULL,
  `Ngay_Tieu_Thu` date DEFAULT NULL,
  `So_Luong_Tieu_Thu` int(11) DEFAULT NULL,
  `Ngay_Het` date DEFAULT NULL,
  `MS_Thuc_An` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_vac_xin`
--

CREATE TABLE `chi_tiet_vac_xin` (
  `MS_Chi_Tiet_Vac_Xin` int(11) NOT NULL,
  `Don_Gia_Vac_Xin` int(11) DEFAULT NULL,
  `So_Luong_Vac_Xin` int(11) DEFAULT NULL,
  `Ngay_Nhap_Vac_Xin` date DEFAULT NULL,
  `Han_Su_Dung_Vac_Xin` date DEFAULT NULL,
  `MS_Vac_Xin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_lon`
--

CREATE TABLE `loai_lon` (
  `MS_Loai_Lon` int(11) NOT NULL,
  `Ten_Loai_Lon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loai_lon`
--

INSERT INTO `loai_lon` (`MS_Loai_Lon`, `Ten_Loai_Lon`) VALUES
(1, 'Lợn nái'),
(2, 'Lợn thịt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_thuc_an`
--

CREATE TABLE `loai_thuc_an` (
  `MS_Loai_Thuc_An` int(11) NOT NULL,
  `Ten_Loai_Thuc_An` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loai_thuc_an`
--

INSERT INTO `loai_thuc_an` (`MS_Loai_Thuc_An`, `Ten_Loai_Thuc_An`) VALUES
(1, 'Thức ăn cho lợn nái'),
(2, 'Thức ăn cho lợn thịt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_vac_xin`
--

CREATE TABLE `loai_vac_xin` (
  `MS_Loai_Vac_Xin` int(11) NOT NULL,
  `Ten_Loai_Vac_Xin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loai_vac_xin`
--

INSERT INTO `loai_vac_xin` (`MS_Loai_Vac_Xin`, `Ten_Loai_Vac_Xin`) VALUES
(1, 'Lợn nái trước khi phối giống'),
(2, 'Lợn nái sau khi phối giống'),
(3, 'Lợn nái sau khi sinh'),
(4, 'Lợn thịt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lon`
--

CREATE TABLE `lon` (
  `MS_Tai_Lon` int(11) NOT NULL,
  `Gioi_Tinh_Lon` varchar(3) DEFAULT NULL,
  `Tuoi_Lon` varchar(50) DEFAULT NULL,
  `MS_Loai_Lon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `lon`
--

INSERT INTO `lon` (`MS_Tai_Lon`, `Gioi_Tinh_Lon`, `Tuoi_Lon`, `MS_Loai_Lon`) VALUES
(1, 'Đực', '14 tháng 8 ngày', 2),
(2, 'Cái', '168 ngày', 1),
(3, 'Cái', '1 tháng 25 ngày', 1),
(4, 'Cái', '2 tháng 15 ngày', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuc_an`
--

CREATE TABLE `thuc_an` (
  `MS_Thuc_An` int(11) NOT NULL,
  `Ten_Thuc_An` varchar(50) NOT NULL,
  `Nha_San_Xuat_Thuc_An` varchar(50) DEFAULT NULL,
  `MS_Loai_Thuc_An` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `thuc_an`
--

INSERT INTO `thuc_an` (`MS_Thuc_An`, `Ten_Thuc_An`, `Nha_San_Xuat_Thuc_An`, `MS_Loai_Thuc_An`) VALUES
(1, 'Bio-zeem Mama 00-02', 'ANCO', 1),
(2, 'Anco U71', 'ANCO', 1),
(3, 'Bio-zeem 20S+', 'ANCO', 2),
(4, 'Anco 20-50S U41S', 'ANCO', 2),
(5, 'Lái Thiêu Premium 26', 'Lái Thiêu', 2),
(6, 'Premium 9 (Nái đẻ & tiết sữa nuôi con)', 'Lái Thiêu', 1),
(7, 'ViNa 102S', 'ViNa', 2),
(8, 'ViNa 107S', 'ViNa', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vac_xin`
--

CREATE TABLE `vac_xin` (
  `MS_Vac_Xin` int(11) NOT NULL,
  `Ten_Vac_Xin` varchar(50) NOT NULL,
  `MS_Loai_Vac_Xin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `vac_xin`
--

INSERT INTO `vac_xin` (`MS_Vac_Xin`, `Ten_Vac_Xin`, `MS_Loai_Vac_Xin`) VALUES
(1, 'Tả', 2),
(2, 'Ecoli', 2),
(3, 'Tẩy Giun', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chi_tiet_lon_nai`
--
ALTER TABLE `chi_tiet_lon_nai`
  ADD PRIMARY KEY (`MS_Chi_Tiet_Lon_Nai`),
  ADD KEY `MS_Tai_Lon` (`MS_Tai_Lon`);

--
-- Chỉ mục cho bảng `chi_tiet_lon_thit`
--
ALTER TABLE `chi_tiet_lon_thit`
  ADD PRIMARY KEY (`MS_Chi_Tiet_Lon_Thit`),
  ADD KEY `MS_Tai_Lon` (`MS_Tai_Lon`);

--
-- Chỉ mục cho bảng `chi_tiet_thuc_an`
--
ALTER TABLE `chi_tiet_thuc_an`
  ADD PRIMARY KEY (`MS_Chi_Tiet_Thuc_An`),
  ADD KEY `MS_Thuc_An` (`MS_Thuc_An`);

--
-- Chỉ mục cho bảng `chi_tiet_tiem`
--
ALTER TABLE `chi_tiet_tiem`
  ADD PRIMARY KEY (`MS_Chi_Tiet_Tiem`),
  ADD KEY `MS_Vac_Xin` (`MS_Vac_Xin`),
  ADD KEY `MS_Tai_Lon` (`MS_Tai_Lon`);

--
-- Chỉ mục cho bảng `chi_tiet_tieu_thu_thuc_an`
--
ALTER TABLE `chi_tiet_tieu_thu_thuc_an`
  ADD PRIMARY KEY (`MS_Chi_Tiet_Tieu_Thu_Thuc_An`),
  ADD KEY `MS_Thuc_An` (`MS_Thuc_An`);

--
-- Chỉ mục cho bảng `chi_tiet_vac_xin`
--
ALTER TABLE `chi_tiet_vac_xin`
  ADD PRIMARY KEY (`MS_Chi_Tiet_Vac_Xin`),
  ADD KEY `MS_Vac_Xin` (`MS_Vac_Xin`);

--
-- Chỉ mục cho bảng `loai_lon`
--
ALTER TABLE `loai_lon`
  ADD PRIMARY KEY (`MS_Loai_Lon`);

--
-- Chỉ mục cho bảng `loai_thuc_an`
--
ALTER TABLE `loai_thuc_an`
  ADD PRIMARY KEY (`MS_Loai_Thuc_An`);

--
-- Chỉ mục cho bảng `loai_vac_xin`
--
ALTER TABLE `loai_vac_xin`
  ADD PRIMARY KEY (`MS_Loai_Vac_Xin`);

--
-- Chỉ mục cho bảng `lon`
--
ALTER TABLE `lon`
  ADD PRIMARY KEY (`MS_Tai_Lon`),
  ADD KEY `MS_Loai_Lon` (`MS_Loai_Lon`);

--
-- Chỉ mục cho bảng `thuc_an`
--
ALTER TABLE `thuc_an`
  ADD PRIMARY KEY (`MS_Thuc_An`),
  ADD KEY `MS_Loai_Thuc_An` (`MS_Loai_Thuc_An`);

--
-- Chỉ mục cho bảng `vac_xin`
--
ALTER TABLE `vac_xin`
  ADD PRIMARY KEY (`MS_Vac_Xin`),
  ADD KEY `MS_Loai_Vac_Xin` (`MS_Loai_Vac_Xin`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chi_tiet_lon_nai`
--
ALTER TABLE `chi_tiet_lon_nai`
  MODIFY `MS_Chi_Tiet_Lon_Nai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_lon_thit`
--
ALTER TABLE `chi_tiet_lon_thit`
  MODIFY `MS_Chi_Tiet_Lon_Thit` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_thuc_an`
--
ALTER TABLE `chi_tiet_thuc_an`
  MODIFY `MS_Chi_Tiet_Thuc_An` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_tiem`
--
ALTER TABLE `chi_tiet_tiem`
  MODIFY `MS_Chi_Tiet_Tiem` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_tieu_thu_thuc_an`
--
ALTER TABLE `chi_tiet_tieu_thu_thuc_an`
  MODIFY `MS_Chi_Tiet_Tieu_Thu_Thuc_An` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_vac_xin`
--
ALTER TABLE `chi_tiet_vac_xin`
  MODIFY `MS_Chi_Tiet_Vac_Xin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loai_lon`
--
ALTER TABLE `loai_lon`
  MODIFY `MS_Loai_Lon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `loai_thuc_an`
--
ALTER TABLE `loai_thuc_an`
  MODIFY `MS_Loai_Thuc_An` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `loai_vac_xin`
--
ALTER TABLE `loai_vac_xin`
  MODIFY `MS_Loai_Vac_Xin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `lon`
--
ALTER TABLE `lon`
  MODIFY `MS_Tai_Lon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `thuc_an`
--
ALTER TABLE `thuc_an`
  MODIFY `MS_Thuc_An` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `vac_xin`
--
ALTER TABLE `vac_xin`
  MODIFY `MS_Vac_Xin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chi_tiet_lon_nai`
--
ALTER TABLE `chi_tiet_lon_nai`
  ADD CONSTRAINT `FK_chi_tiet_lon_nai_lon_MS_Tai_Lon` FOREIGN KEY (`MS_Tai_Lon`) REFERENCES `lon` (`MS_Tai_Lon`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chi_tiet_lon_thit`
--
ALTER TABLE `chi_tiet_lon_thit`
  ADD CONSTRAINT `FK_chi_tiet_lon_thit_lon_MS_Tai_Lon` FOREIGN KEY (`MS_Tai_Lon`) REFERENCES `lon` (`MS_Tai_Lon`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chi_tiet_thuc_an`
--
ALTER TABLE `chi_tiet_thuc_an`
  ADD CONSTRAINT `FK_chi_tiet_thuc_an_thuc_an_MS_Thuc_An` FOREIGN KEY (`MS_Thuc_An`) REFERENCES `thuc_an` (`MS_Thuc_An`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chi_tiet_tiem`
--
ALTER TABLE `chi_tiet_tiem`
  ADD CONSTRAINT `FK_chi_tiet_tiem_lon_MS_Tai_Lon` FOREIGN KEY (`MS_Tai_Lon`) REFERENCES `lon` (`MS_Tai_Lon`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_chi_tiet_tiem_vac_xin_MS_Vac_Xin` FOREIGN KEY (`MS_Vac_Xin`) REFERENCES `vac_xin` (`MS_Vac_Xin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chi_tiet_tieu_thu_thuc_an`
--
ALTER TABLE `chi_tiet_tieu_thu_thuc_an`
  ADD CONSTRAINT `FK_chi_tiet_tieu_thu_thuc_an_thuc_an_MS_Thuc_An` FOREIGN KEY (`MS_Thuc_An`) REFERENCES `thuc_an` (`MS_Thuc_An`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chi_tiet_vac_xin`
--
ALTER TABLE `chi_tiet_vac_xin`
  ADD CONSTRAINT `FK_chi_tiet_vac_xin_vac_xin_MS_Vac_Xin` FOREIGN KEY (`MS_Vac_Xin`) REFERENCES `vac_xin` (`MS_Vac_Xin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `lon`
--
ALTER TABLE `lon`
  ADD CONSTRAINT `FK_lon_loai_lon_MS_Loai_Lon` FOREIGN KEY (`MS_Loai_Lon`) REFERENCES `loai_lon` (`MS_Loai_Lon`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `thuc_an`
--
ALTER TABLE `thuc_an`
  ADD CONSTRAINT `FK_thuc_an_loai_thuc_an_MS_Loai_Thuc_An` FOREIGN KEY (`MS_Loai_Thuc_An`) REFERENCES `loai_thuc_an` (`MS_Loai_Thuc_An`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `vac_xin`
--
ALTER TABLE `vac_xin`
  ADD CONSTRAINT `FK_vac_xin_loai_vac_xin_MS_Loai_Vac_Xin` FOREIGN KEY (`MS_Loai_Vac_Xin`) REFERENCES `loai_vac_xin` (`MS_Loai_Vac_Xin`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
