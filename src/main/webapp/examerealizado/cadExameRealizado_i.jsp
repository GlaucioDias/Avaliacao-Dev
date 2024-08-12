<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="Cadastrar novo exame" /></title>
<link rel='stylesheet'
	href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body class="bg-secondary">
	<s:include value="/includes/topMenu.jsp">
	</s:include>
    <div class="container mt-5">
        <s:form action="salvarExamesRealizados">
            <div class="card">
                <div class="card-header">
                    <div class="d-flex flex-row">
                        <div class="col-sm-3">
                            <s:url action="todosExamesRealizados" var="todos" />
                            <a href="${todos}" class="btn btn-success">Exames Realizados</a>
                        </div>

                        <div class="col-sm-6 text-center">
                            <h5 class="card-title mb-0">Cadastrar Novo Exame</h5>
                        </div>
                    </div>
                </div>

                <div class="card-body">
                    <div class="row">

                        <div class="col-sm-4 mb-3">
                            <label for="idFuncionario" class="form-label">ID do Funcionario:</label>
                            <s:textfield cssClass="form-control" id="idFuncionario" name="exameRealizadoVo.funcionarioVo.rowid" type="number" required="true"/>
                        </div>

                        <div class="col-sm-4 mb-3">
                            <label for="idExame" class="form-label">ID do Exame:</label>
                            <s:textfield cssClass="form-control" id="idExame" name="exameRealizadoVo.exameVo.rowid" type="number" required="true"/>
                        </div>

                        <div class="col-sm-4 mb-3">
                            <label for="dataExame" class="form-label">Data do Exame:</label>
                            <s:textfield cssClass="form-control" id="dataExame" name="exameRealizadoVo.dataExame" type="date" required="true" />
                        </div>
                    </div>
                </div>

                <div class="card-footer">
                    <div class="row">
                        <div class="col text-left">
                            <button class="btn btn-primary">Salvar</button>
                        </div>
                        <div class="col-sm-2">
                            <button type="reset" class="btn btn-secondary">Limpar Formulario</button>
                        </div>
                    </div>
                </div>
            </div>
        </s:form>
    </div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>