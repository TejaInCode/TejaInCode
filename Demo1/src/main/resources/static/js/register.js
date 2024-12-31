function toggleDepartmentField() {
    const userType = document.getElementById("userType").value;
    const departmentField = document.getElementById("departmentField");

    if (userType === "Normal User") {
        departmentField.classList.remove("hidden");
    } else {
        departmentField.classList.add("hidden");
    }
}

// Hide the success message after 5 seconds
document.addEventListener("DOMContentLoaded", () => {
    const successMessage = document.getElementById("successMessage");
    if (successMessage) {
        setTimeout(() => {
            successMessage.style.display = 'none';
        }, 3000); // 5 seconds
    }
});
