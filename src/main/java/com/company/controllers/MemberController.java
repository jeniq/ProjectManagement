package com.company.controllers;

import com.company.entities.AccessType;
import com.company.entities.Member;
import com.company.entities.Position;
import com.company.services.impls.AccessTypeService;
import com.company.services.impls.MemberService;
import com.company.services.impls.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private AccessTypeService accessTypeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/newMember", method = RequestMethod.GET)
    public ModelAndView newMember() {
        ModelAndView modelAndView = new ModelAndView();

        List<Position> positionList = positionService.getPositionList();
        List<AccessType> accessTypeList = accessTypeService.getAccessTypeList();

        modelAndView.addObject(Constant.NEW_MEMBER, new Member());
        modelAndView.addObject(Constant.POSITION_LIST, positionList);
        modelAndView.addObject(Constant.ACCESS_TYPE_LIST, accessTypeList);

        modelAndView.setViewName(Page.CREATE_MEMBER_POPUP);

        return modelAndView;
    }

    // Creates member using request
    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public String addMember(HttpServletRequest request) {
        Member member = new Member();

        member.setName(request.getParameter(Constant.NAME));
        member.setSurname(request.getParameter(Constant.SURNAME));
        member.setEmail(request.getParameter(Constant.EMAIL));
        member.setPassword(request.getParameter(Constant.PASSWORD));
        member.setAccessType(accessTypeService.getById(Integer.parseInt(request.getParameter(Constant.ACCESS_TYPE))));
        member.setPosition(positionService.getById(Integer.parseInt(request.getParameter(Constant.POSITION))));

        memberService.add(member);

        return Page.REDIRECT_DEFAULT;
    }
}
