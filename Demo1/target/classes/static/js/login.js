function toggleDepartmentField() {
    const userType = document.getElementById("userType").value;
    const departmentField = document.getElementById("departmentField");

    if (userType === "Normal User") {
        departmentField.classList.remove("hidden");
    } else {
        departmentField.classList.add("hidden");
    }
}