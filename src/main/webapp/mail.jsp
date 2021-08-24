<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
        <script type="text/javascript" >
            function sendMail()
            {
                var mailBody = document.getElementById('mailBody').innerHTML;
                var mailBody2 = mailBody;
                var mailSubject = document.getElementById('tbAsunto').value;
                var mailDestinatary = document.getElementById('tbEmail').value;
                window.location = "mailto:" + mailDestinatary + "?subject=" + mailSubject + "&body=" + mailBody2;
            }
            function OpenOutlookNewEmail()
            {
                try
                {
                    var outlookApp = new ActiveXObject("Outlook.Application");
                    var nameSpace = outlookApp.getNameSpace("MAPI");
                    var mailBody = document.getElementById('mailBody').innerHTML;
                    var mailBody2 = encodeURIComponent(mailBody);
                    var mailSubject = document.getElementById('tbAsunto').value;
                    var mailDestinatary = document.getElementById('tbEmail').value;
                
                
                    mailFolder = nameSpace.getDefaultFolder(6);
                    mailItem = mailFolder.Items.add('IPM.Note.FormA');
                    mailItem.Subject = mailSubject;
                    mailItem.To = mailDestinatary;
                    mailItem.HTMLBody =mailBody;
                    mailItem.display(0);
                } catch (e)
                {
                    alert(e);
// act on any error that you get
                }
            }

        </script>
    </head>

    <body>

        Email Body TESTER
        <p>Email</p> <br/>
        <input type="text" id="tbEmail" name="tbEmail" style="width:500px;" value="victorb@mailer.com.py"/><br/>
        <p>Asunto</p><br/>
        <input type="text" id="tbAsunto" name="tbAsunto"  style="width:500px;" value="Notificacion de contacto"/><br/>

        <div id="mailBody" style="display:none;">
            <table width="600" border="0" cellspacing="10" cellpadding="0" style="border:5px solid #ff9933;background:url(https://ci3.googleusercontent.com/proxy/4RZAHLyCzuojicz3I-FuNWQ6-dXXA5lM9HNQc_m1_iNAKh36hd9d_FjMKKSQHB5xTtJc-LLrGI_Bj3dv0xVcTzlKFc7z5iHapsdSIlMLbKrDgvTp2oB1=s0-d-e1-ft#https://www.secure.itau.com.py/images/ebank/itau/email/irroba.png) center no-repeat">
                <tbody><tr><td align="left"><img src="https://www.secure.itau.com.py/images/ebank/itau/email/logo_itau.png" width="74" height="78" class="CToWUd"></td><td align="right"><img src="https://www.secure.itau.com.py/images/ebank/itau/24horas.png" width="74" height="78" class="CToWUd"></td></tr>

                    <tr>
                        <td colspan="2">
                            <b>
                                <p style="font-size:16px;color: #282832; font-weight: bold; ">CARLOS ERICK BUSTAMANTE MUÑOZ</p>
                            </b>
                            <p>Te informamos que su reclamo n# 123123 ha sido procesado exitosamente &nbsp;</p>
                        </td>
                    </tr>                    

                <td colspan="2"><p><font color="gray" size="2" face="Arial">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ante cualquier duda, contacta con nuestro Servicio de Atención al Cliente 24 horas<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;en el Teléfono: <a href="tel:%28021%29%20617%201000" value="+595216171000" target="_blank">(021) 617 1000</a> ó a la dirección de email: <a href="mailto:sac@itau.com.py" target="_blank"><font color="#FF9933">sac@<span class="il">itau</span>.com.py</font></a></font></p><br><br>
                </td>
            </tr><tr><td colspan="2"></td></tr></tbody></table>
</div>
<input type="button"  value="Enviar Correo" onclick="sendMail();">
<input type="button"  value="Enviar Correo para Outlook" onclick="javascript:OpenOutlookNewEmail();">
</body>
</html>
