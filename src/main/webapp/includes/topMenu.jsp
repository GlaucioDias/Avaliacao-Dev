<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set var="activeMenu" scope="page">${param.active}</s:set>

<header class="p-3 bg-primary bg-gradient  sticky-top">
  <div class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
     

      <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li>
          <s:url var="index_url" action="todosExames"/>
          <s:if test='#attr.activeMenu == "exames"'>
            <s:a href="%{index_url}" cssClass="nav-link px-2 text-dark" aria-current="page"><i class="bi bi-house"></i> Exames</s:a>
          </s:if>
          <s:else>
            <s:a href="%{index_url}" cssClass="nav-link px-2 text-white"><i class="bi bi-house"></i> Exames</s:a>
          </s:else>
        </li>
        <li>
          <s:url var="funcionario_url" action="todosFuncionarios"/>
          <s:if test='#attr.activeMenu == "funcionarios"'>
            <s:a href="%{funcionario_url}" cssClass="nav-link px-2 text-dark" aria-current="page"><i class="bi bi-postcard"></i> Funcionarios</s:a>
          </s:if>
          <s:else>
            <s:a href="%{funcionario_url}" cssClass="nav-link px-2 text-white"><i class="bi bi-postcard"></i> Funcionarios</s:a>
          </s:else>
        </li>
        <li>
          <s:url var="exame_realizado_url" action="todosExamesRealizados"/>
          <s:if test='#attr.activeMenu == "realizados"'>
            <s:a href="%{exame_realizado_url}" cssClass="nav-link px-2 text-dark" aria-current="page"><i class="bi bi-postcard"></i>Exames realizados</s:a>
          </s:if>
          <s:else>
            <s:a href="%{exame_realizado_url}" cssClass="nav-link px-2 text-white"><i class="bi bi-postcard"></i>Exames realizados</s:a>
          </s:else>
        </li>
        <li>
        	<s:url var="relatorio_url" action="listarRelatorios" />
        	 <s:if test='#attr.activeMenu == "relatorio"'>
            <s:a href="%{exame_realizado_url}" cssClass="nav-link px-2 text-dark" aria-current="page"><i class="bi bi-postcard"></i>Relatorio</s:a>
          </s:if>
          <s:else>
            <s:a href="%{relatorio_url}" cssClass="nav-link px-2 text-white"><i class="bi bi-postcard"></i>Relatorio</s:a>
          </s:else>
        </li>
      </ul>
    </div>
  </div>
</header>


<!-- <main class="d-flex flex-nowrap"> -->

<!--   <div class="container-xxl bd-gutter mt-3 my-md-4 bd-layout"> -->
<!--     <div class="row"> -->