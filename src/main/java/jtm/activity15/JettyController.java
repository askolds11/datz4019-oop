package jtm.activity15;

import jtm.activity13.Teacher;
import jtm.activity13.TeacherManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class JettyController {

	TeacherManager manager;

	/**
	 * method which is invoked when root folder (i.e. http://localhost:8801/) of
	 * web application is requested. This method doesn't take any parameters
	 * passed in URL (address).
	 * 
	 * @return string as HTML response to the request using UTF-8 encoding for
	 *         non-Latin characters.
	 */
	@GetMapping("")
	@ResponseBody
	// This method should work without declared name parameter, request and
	// response objects,
	// but it shows, how passed request and returned response can be used inside
	// method
	public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href='/insertTeacher'>Insert teacher<a><br/>\n");
		sb.append("<a href='/findTeacher'>Find teacher<a><br/>\n");
		sb.append("<a href='/deleteTeacher'>Delete teacher<a><br/>\n");
		// Following is also redundant because status is OK by default:
		response.setStatus(HttpServletResponse.SC_OK);
		return sb.toString();
	}

	@GetMapping("/insertTeacher")
	@ResponseBody
	public String insertTeacher(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname,
			HttpServletRequest request,
			HttpServletResponse response
	) {
		initManager();
		StringBuilder sb = new StringBuilder();

		response.setStatus(HttpServletResponse.SC_OK);
		if (name == null && surname == null) {
			sb.append("<form action=''>\n" +
					"Name: <input type='text' name='name' value=''><br/>\n" +
					"Surname: <input type='text' name='surname' value=''><br/>\n" +
					"<input type='submit' value='Insert'></form><br/>\n" +
					"<a href='/'>Back</a>\n");
		}
		else if (name == null || name.isBlank() || surname == null || surname.isBlank()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			sb.append("false<br/>\n" +
					"<a href='/'>Back</a>\n");
		} else {
			manager.insertTeacher(name, surname);
			sb.append("true<br/>\n" +
					"<a href='/'>Back</a>\n");
		}

		return sb.toString();
	}

	@GetMapping("/findTeacher")
	@ResponseBody
	public String findTeacher(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname,
			HttpServletRequest request,
			HttpServletResponse response
	) {
		initManager();
		StringBuilder sb = new StringBuilder();

		if (name == null && surname == null) {
			sb.append("<form action=''>\n" +
					"Name: <input type='text' name='name' value=''><br/>\n" +
					"Surname: <input type='text' name='surname' value=''><br/>\n" +
					"<input type='submit' value='Find'></form><br/>\n" +
					"<a href='/'>Back</a>\n");
		}
		else {
			List<Teacher> teachers = manager.findTeacher(name, surname);
			sb.append("<form action=''>\n" +
					"Name: <input type='text' name='name' value=''><br/>\n" +
					"Surname: <input type='text' name='surname' value=''><br/>\n" +
					"<input type='submit' value='Find'></form><br/>\n" +
					"<table>\n");
			for (Teacher teacher : teachers) {
				sb.append("<tr>\n")
					.append("<td>").append(teacher.getId()).append("</td>\n")
					.append("<td>").append(teacher.getFirstName()).append("</td>\n")
					.append("<td>").append(teacher.getLastName()).append("</td>\n")
					.append("</tr>\n");
			}

			sb.append("</table><br>\n");
			sb.append("<a href='/'>Back</a>\n");
		}

		response.setStatus(HttpServletResponse.SC_OK);
		return sb.toString();
	}

	@GetMapping("/deleteTeacher")
	@ResponseBody
	public String deleteTeacher(
			@RequestParam(value = "id", required = false) String idString,
			HttpServletRequest request,
			HttpServletResponse response
	) {
		initManager();
		StringBuilder sb = new StringBuilder();

		Integer id;
		try {
			id = Integer.parseInt(idString);
		} catch (NumberFormatException e) {
			id = null;
		}

		if (idString == null) {
			response.setStatus(HttpServletResponse.SC_OK);
			sb.append("<form action=''>\n" +
					"ID: <input type='text' name='id' value=''><br/>\n" +
					"<input type='submit' value='Delete'></form><br/>\n" +
					"<a href='/'>Back</a>\n");
		}
		else if (idString.isBlank() || (id != null && !manager.deleteTeacher(id))) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			sb.append("false<br/>\n" +
					"<a href='/'>Back</a>\n");
		}
		else {
			response.setStatus(HttpServletResponse.SC_OK);
			sb.append("true<br/>\n" +
					"<a href='/'>Back</a>\n");
		}

		return sb.toString();
	}

	private void initManager() {
		if (manager == null) {
			manager = new TeacherManager();
		}
	}
}
