package com.codegym.repository.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeclarationRepository implements IDeclarationRepository {
    private final List<Integer> dateOfbirthList = new ArrayList<>();
    private final List<String> genderList = new ArrayList<>();
    private final List<String> natronalityList = new ArrayList<>();
    private final List<String> renderList = new ArrayList<>();
    private final List<Integer> startDayList = new ArrayList<>();
    private final List<Integer> startMonthList = new ArrayList<>();
    private final List<Integer> startYearList = new ArrayList<>();
    private final List<Integer> endDayList = new ArrayList<>();
    private final List<Integer> endMonthList = new ArrayList<>();
    private final List<Integer> endYearList = new ArrayList<>();
    private final List<Declaration> declarationList = new ArrayList<>();

    {
        for (int i = 1950; i <= 2005; i++) {
            dateOfbirthList.add(i);
        }

        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("LGBT");

        natronalityList.add("Việt Nam");
        natronalityList.add("Hoa Kỳ");
        natronalityList.add("Trung Quốc");
        natronalityList.add("Nga");

        renderList.add("Máy bay");
        renderList.add("Tàu thuyền");
        renderList.add("Ô tô");
        renderList.add("Khác");

        for (int i = 1; i <= 30; i++) {
            startDayList.add(i);
        }

        for (int i = 1; i <= 12; i++) {
            startMonthList.add(i);
        }

        startYearList.add(2021);
        startYearList.add(2022);

        for (int i = 1; i <= 30; i++) {
            endDayList.add(i);
        }

        for (int i = 1; i <= 12; i++) {
            endMonthList.add(i);
        }

        endYearList.add(2021);
        endYearList.add(2022);

        declarationList.add(new Declaration("Lê Đại Lợi", "1997", "Nam", "Việt Nam",
                "123450123", "Ô tô", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà, chưa đi đâu"));
        declarationList.add(new Declaration("Đặng Thị Thuỷ Tiên", "2000", "Nữ", "Việt Nam",
                "123451234", "Tàu hỏa", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có tới nhà Tý,..."));
        declarationList.add(new Declaration("Nguyễn Tất Thành", "2000", "Nam", "Việt Nam",
                "123455678", "Xe máy", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà cả tuần trả bài, chưa đi đâu"));
        declarationList.add(new Declaration("Hoàng Minh Trí", "1998", "Nữ", "Việt Nam",
                "123452222", "Xe xích lô", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Hay đi sang nhà Diễm"));
        declarationList.add(new Declaration("Phan Phước Đại", "1990", "Nữ", "Việt Nam",
                "121125678", "Xe ba gác", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có đi siêu thị, nhà ông Đạt"));
        declarationList.add(new Declaration("Phạm Đạt", "1993", "Nữ", "Việt Nam",
                "355455678", "Xe rác", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà, chưa đi đâu"));
        declarationList.add(new Declaration("Huỳnh Trung Thuyên", "1994", "Nam", "Việt Nam",
                "129000678", "Đi bộ", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà bạn A trong tuần"));
        declarationList.add(new Declaration("Võ Văn Tý", "2001", "Nam", "Việt Nam",
                "222455678", "Tên lửa", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà bạn Tiên,..."));
        declarationList.add(new Declaration("Nguyễn Văn Phúc", "1998", "Nam", "Việt Nam",
                "120985678", "Bay", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Đi chợ A..."));
        declarationList.add(new Declaration("Đặng Ngọc Huy", "1998", "Nam", "Việt Nam",
                "123409978", "Tàu ngầm", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có đi tới nhà Hùng"));
        declarationList.add(new Declaration("Bùi Chí Bảo", "2001", "Nam", "Việt Nam",
                "123455600", "Xe đạp", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Ở nhà trong tuần"));
        declarationList.add(new Declaration("Nguyễn Văn Thanh", "1999", "Nam", "Việt Nam",
                "933455678", "Cuốc bộ", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Có đi sang nhà A,.."));
        declarationList.add(new Declaration("Nguyễn Tấn Huân", "1997", "Nam", "Việt Nam",
                "513455678", "Tàu điện ngầm", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Không đi đâu, chỉ ở nhà"));
        declarationList.add(new Declaration("Huỳnh Văn Nam", "1993", "Nam", "Việt Nam",
                "841255678", "Xe tăng", "20302", "10", 10, 10, 2021, 11,
                11, 2022, "Đi ngủ nguyên tuần"));
    }

    @Override
    public List<Integer> dateOfBirthList() {
        return dateOfbirthList;
    }

    @Override
    public List<String> genderList() {
        return genderList;
    }

    @Override
    public List<String> natronalityList() {
        return natronalityList;
    }

    @Override
    public List<String> renderList() {
        return renderList;
    }

    @Override
    public List<Integer> startDayList() {
        return startDayList;
    }

    @Override
    public List<Integer> startMonthList() {
        return startMonthList;
    }

    @Override
    public List<Integer> startYearList() {
        return startYearList;
    }

    @Override
    public List<Integer> endDayList() {
        return endDayList;
    }

    @Override
    public List<Integer> endMonthList() {
        return endMonthList;
    }

    @Override
    public List<Integer> endYearList() {
        return endYearList;
    }

    @Override
    public List<Declaration> findAll() {
        return declarationList;
    }

    @Override
    public Declaration findOne(String identity) {
        Declaration declaration = null;

        for (Declaration item : declarationList) {
            if (item.getIdentity().equals(identity)) {
                declaration = new Declaration(item.getName(), item.getDateOfBirth(),
                        item.getGender(), item.getNationality(), item.getIdentity(), item.getRender(),
                        item.getVehicleNumber(), item.getSeats(), item.getStartDay(), item.getStartMonth(),
                        item.getStartYear(), item.getEndDay(), item.getEndMonth(), item.getEndYear(),
                        item.getInformation());
            }
        }
        return declaration;
    }

    @Override
    public void update(String identity, Declaration declaration) {
        for (Declaration item : declarationList) {
            if (item.getIdentity().equals(identity)) {
                item.setName(declaration.getName());
                item.setDateOfBirth(declaration.getDateOfBirth());
                item.setGender(declaration.getGender());
                item.setNationality(declaration.getNationality());
                item.setIdentity(declaration.getIdentity());
                item.setRender(declaration.getRender());
                item.setVehicleNumber(declaration.getVehicleNumber());
                item.setStartDay(declaration.getStartDay());
                item.setStartMonth(declaration.getStartMonth());
                item.setStartYear(declaration.getStartYear());
                item.setEndDay(declaration.getEndDay());
                item.setEndMonth(declaration.getEndMonth());
                item.setEndYear(declaration.getEndYear());
                item.setInformation(declaration.getInformation());
            }
        }
    }

    @Override
    public void save(Declaration declaration) {
        declarationList.add(declaration);
    }
}
