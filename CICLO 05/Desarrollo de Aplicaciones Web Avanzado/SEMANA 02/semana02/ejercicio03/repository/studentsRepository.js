let students = [
  {
    id: 1,
    name: "Juan Perez",
    grade: 20,
    age: 23,
    email: "juan.perez@ejemplo.com",
    phone: "+51 987654321",
    enrollmentNumber: "2025001",
    course: "Diseno y Desarrollo de Software C24",
    year: 3,
    subjects: ["Algoritmos", "Bases de Datos", "Redes"],
    gpa: 3.8,
    status: "Activo",
    admissionDate: "2022-03-01"
  },
  {
    id: 2,
    name: "Ana Torres",
    grade: 17,
    age: 22,
    email: "ana.torres@ejemplo.com",
    phone: "+51 912345678",
    enrollmentNumber: "2025002",
    course: "Diseno y Desarrollo de Software C24",
    year: 2,
    subjects: ["Programacion Web", "Matematicas"],
    gpa: 3.4,
    status: "Activo",
    admissionDate: "2023-03-20"
  },
  {
    id: 3,
    name: "Luis Ramos",
    grade: 13,
    age: 24,
    email: "luis.ramos@ejemplo.com",
    phone: "+51 998112233",
    enrollmentNumber: "2025003",
    course: "Diseno y Desarrollo de Software C24",
    year: 4,
    subjects: ["Arquitectura", "DevOps"],
    gpa: 2.7,
    status: "Inactivo",
    admissionDate: "2021-08-12"
  }
];

function getAll() {
  return students;
}

function getById(id) {
  return students.find(s => s.id === id);
}

function create(student) {
  const maxId = students.reduce((max, current) => Math.max(max, current.id), 0);
  student.id = maxId + 1;
  students.push(student);
  return student;
}

function update(id, updateData) {
  const index = students.findIndex(s => s.id === id);
  if (index !== -1) {
    students[index] = { ...students[index], ...updateData };
    return students[index];
  }
  return null;
}

function remove(id) {
  const index = students.findIndex(s => s.id === id);
  if (index !== -1) {
    return students.splice(index, 1)[0];
  }
  return null;
}

function listByStatus(status) {
  const statusText = String(status).trim().toLowerCase();
  return students.filter(s => String(s.status || "").trim().toLowerCase() === statusText);
}

function listByGrade(filters = {}) {
  const hasGpa = filters.gpa !== undefined;
  const hasGrade = filters.grade !== undefined;

  return students.filter(student => {
    const matchGpa = hasGpa ? Number(student.gpa) === Number(filters.gpa) : true;
    const matchGrade = hasGrade ? Number(student.grade) === Number(filters.grade) : true;
    return matchGpa && matchGrade;
  });
}

module.exports = { getAll, getById, create, update, remove, listByStatus, listByGrade };