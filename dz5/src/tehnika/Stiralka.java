/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehnika;


abstract class Stiralka extends Tehnika {

    private String privod;
    private boolean rezhimDeti;
    private boolean vstraiv;

    @Override
    void voice() {
        System.out.println("vzh-zh-zh");
    }

    public String getPrivod() {
        return privod;
    }

    public void setPrivod(String privod) {
        this.privod = privod;
    }

    public boolean isRezhimDeti() {
        return rezhimDeti;
    }

    public void setRezhimDeti(boolean rezhimDeti) {
        this.rezhimDeti = rezhimDeti;
    }

    public boolean isVstraiv() {
        return vstraiv;
    }

    public void setVstraiv(boolean vstraiv) {
        this.vstraiv = vstraiv;
    }
}
