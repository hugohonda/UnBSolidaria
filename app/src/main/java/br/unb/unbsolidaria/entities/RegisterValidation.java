package br.unb.unbsolidaria.entities;

/**
 * Created by lucasrez on 02/11/16.
 */

public class RegisterValidation {
    private static final int[] cpfWeight = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] cnpjWeight = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calculateDigit(String str, int[] weight) {
        int sum = 0;
        for (int index = str.length() - 1, digit; index >= 0; index--) {
            digit = Integer.parseInt(str.substring(index, index + 1));
            sum += digit * weight[weight.length - str.length() + index];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) return false;

        Integer weight1 = calculateDigit(cpf.substring(0, 9), cpfWeight);
        Integer weight2 = calculateDigit(cpf.substring(0, 9) + weight1, cpfWeight);
        return cpf.equals(cpf.substring(0, 9) + weight1.toString() + weight2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) return false;

        Integer weight1 = calculateDigit(cnpj.substring(0, 12), cnpjWeight);
        Integer weight2 = calculateDigit(cnpj.substring(0, 12) + weight1, cnpjWeight);
        return cnpj.equals(cnpj.substring(0, 12) + weight1.toString() + weight2.toString());
    }

    public static boolean isValidCEP(String cep) {
        String cepRegEx = "\\d{5}-?\\d{3}";
        return cep.matches(cepRegEx);
    }

    public static boolean isValidMatricula(String matricula) {
        String matriculaRegEx = "^[0-9]{9}$";
        return matricula.matches(matriculaRegEx);
    }

    public static void main(String[] args) {
        System.out.printf("CPF Valido:%s \n", RegisterValidation.isValidCPF("01115375502"));
        System.out.printf("CNPJ Valido:%s \n", RegisterValidation.isValidCNPJ("13642634756318"));
        System.out.printf("CEP Valido:%s \n", RegisterValidation.isValidCEP("12910-180"));
        System.out.printf("Matricula Valida:%s \n", RegisterValidation.isValidMatricula("150019284"));
    }
}
