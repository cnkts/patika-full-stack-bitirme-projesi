import React, { useEffect } from "react";
import "../styles/Menu.css";
import { MdOutlineHome, MdOutlineFolderCopy } from "react-icons/md";
import { Link, NavLink, useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import { Button } from "antd";

function Menu() {
  const navigate = useNavigate()

  const handleHome = () => {
    navigate("/")
    navigate(0);
  }

  const handlePasswordChange = () => {
    navigate("/changepassword")
    navigate(0);
  }
  return (
    <main className="menuMain">
      <Link to={"/"}>
        <img
          style={{ width: "100%", borderRadius: "4px", border: "1px solid #ddd", padding: "5px", marginBottom: "10px" }}
          src="https://img.freepik.com/premium-vector/car-logo-design-star-car-logo-template_148524-154.jpg?w=740"
        />
      </Link>

      <NavLink onClick={handleHome} to={"/"}>
        <section>

          <a class="active" href="#home">Anasayfa</a>

        </section>
      </NavLink>
      {localStorage.getItem("token") ? (
        <NavLink onClick={handlePasswordChange} to={"/changepassword"}>
          <section>

            Şifre Değiştir
          </section>
        </NavLink>
      ) : (
        ""
      )}

      <section></section>

      {localStorage.getItem("token") ? (
        ""
      ) : (
        <>
          <NavLink to={"/login"}>
            <section>

              Giriş Yap
            </section>
          </NavLink>
          <NavLink to={"/register"}>
            <section>

              Kayıt Ol
            </section>
          </NavLink>
        </>
      )}
    </main>
  );
}

export default Menu;
