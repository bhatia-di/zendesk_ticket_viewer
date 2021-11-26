import React from "react";
import {Navbar, NavLink, UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem, NavbarBrand,NavbarText, NavbarToggler, NavItem, Nav, Collapse} from "reactstrap";

export default function Header() {

return (
<div>
  <Navbar
    color="light"
    expand="md"
    light
  >
    <NavbarBrand href="/">

      Zendesk
    </NavbarBrand>
    <NavbarToggler onClick={function noRefCheck(){}} />
    <Collapse navbar>
      <Nav
        className="me-auto"
        navbar
      >
        <NavItem>
          <NavLink href="/tickets" active>
            Tickets
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="/about" active>
            About
          </NavLink>
        </NavItem>

      </Nav>

    </Collapse>
  </Navbar>
</div>


);


}